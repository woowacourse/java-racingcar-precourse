package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 이동_전진() {
        Car car = new Car("테스트");
        car.move(4);

        assertThat(car.to().getPosition()).isEqualTo(1);
    }

    @Test
    void 이동_정지() {
        Car car = new Car("테스트");
        car.move(3);

        assertThat(car.to().getPosition()).isEqualTo(0);
    }
}