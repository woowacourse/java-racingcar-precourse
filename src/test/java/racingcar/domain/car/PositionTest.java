package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositionTest {

    @DisplayName("Position 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 4, 5
    })
    void testInitPosition(int inputPosition) {
        //when
        Position position = new Position(inputPosition);

        //then
        assertThat(position).extracting("position").isEqualTo(inputPosition);
    }

    @DisplayName("Position 값이 Position 최솟값보다 작은 값이 들어올 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {
            -1, -2, -3, -4
    })
    void testInitPositionIfInputValueSmallerThanMinPositionNumber(int inputPosition) {
        //when //then
        assertThatThrownBy(() -> new Position(inputPosition))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
