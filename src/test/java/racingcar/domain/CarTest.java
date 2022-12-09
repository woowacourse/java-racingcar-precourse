package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private final String ERROR = "[ERROR]";

    @DisplayName("이름의 길이가 5자를 넘으면 예외가 발생한다.")
    @Test
    void validateName() {
        String name = "123456";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
