package racingcar.domain.trynumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {

    @DisplayName("tryNumber 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void testInitTryNumber(int number) {
        //when
        TryNumber tryNumber = new TryNumber(number);

        //then
        assertThat(tryNumber).extracting("tryNumber").isEqualTo(number);
    }

    @DisplayName("최소 시도 횟수보다 작은 숫자를 입력받을 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {-3, -1, 0})
    void testInitTryNumberIfNumberIsSmallerThanMinimumTryNumberValue(int number) {
        //when //then
        assertThatThrownBy(() -> new TryNumber(number))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
