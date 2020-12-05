package racingcar.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static Car car;

    @DisplayName("race 기능과 position getter가 제대로 동작하는지 확인한다")
    @Test
    void RACE_동작_및_포지션_getter_확인() {
        car = new Car("");
        int expectedPosition = 3;
        car.race(4);
        car.race(4);
        car.race(4);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("name getter 동작 확인")
    @Test
    void getName() {
        String testName = "TEST NAME";
        car = new Car(testName);

        assertThat(car.getName()).isEqualTo(testName);
    }
}