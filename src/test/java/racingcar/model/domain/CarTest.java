package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 이동_범위_밖_수_예외발생(int number) {
        Car car = new Car("테스트");

        assertThatThrownBy(() -> car.move(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}