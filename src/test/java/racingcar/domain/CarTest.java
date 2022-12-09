package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private final String ERROR = "[ERROR]";

    @DisplayName("이름의 길이가 5자를 넘으면 예외가 발생한다.")
    @Test
    void validateNameWithOverLength() {
        String name = "123456";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("이름이 공백이면 예외가 발생한다.")
    @Test
    void validateNameWithBlank() {
        String name = "";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("숫자가 4이상일 경우 자동차는 전진한다.")
    @Test
    void tryMoveForward() {
        Car car = new Car("test");
        int position = car.getPosition();

        car.tryMoveForward(4);

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }
}
