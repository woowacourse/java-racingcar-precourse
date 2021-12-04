package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("이름이 5자 이하가 아닐 경우 Exception이 발생해야 한다.")
    void createExceptionByLargeNameLengthTest() {
        // given
        String name = "abcdef";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(name))
            .withMessage("[ERROR] Car의 이름은 5자 이하만 입력되어야 합니다.");
    }
}