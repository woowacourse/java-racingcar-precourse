package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoadTest {

    @DisplayName("숫자가 4이상이면 자동차는 움직인다.")
    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    void move(int number) {
        Road road = new Road();
        Car car = new Car("car");

        road.move(car, number);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 4이하면 자동차는 움직인다.")
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    void stop(int number) {
        Road road = new Road();
        Car car = new Car("car");

        road.move(car, number);

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}