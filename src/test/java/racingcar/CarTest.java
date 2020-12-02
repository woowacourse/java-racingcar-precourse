package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    private final int MOVE_FRONT_MIN = 4;

    @Test
    public void Should_Move_Front_When_More_Than_4() {
        Car car = new Car("test");

        for (int i = 0; i <= 5; i++) {
            car.move(MOVE_FRONT_MIN + i);
        }

        assertThat(car.getPosition()).isEqualTo(6);
    }

    @Test
    public void Should_Stop_When_Under_4() {
        Car car = new Car("test");

        for (int i = 1; i <= 4; i++) {
            car.move(MOVE_FRONT_MIN - i);
        }

        assertThat(car.getPosition()).isEqualTo(0);
    }
}