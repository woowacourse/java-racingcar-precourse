package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("숫자가 4 이상이라면 자동차들은 전진한다.")
    @Test
    void raceForwardSuccess() {
        List<Car> car = Stream.of("test", "car").map(Car::new).collect(Collectors.toList());
        Cars cars = new Cars(car);

        cars.race(() -> 4);

        assertThat(cars.getCars().stream().map(Car::getPosition))
                .containsExactly(1, 1);
    }

    @DisplayName("숫자가 4 이상이라면 자동차들은 전진한다.")
    @Test
    void raceForwardFail() {
        List<Car> car = Stream.of("test", "car").map(Car::new).collect(Collectors.toList());
        Cars cars = new Cars(car);

        cars.race(() -> 0);

        assertThat(cars.getCars().stream().map(Car::getPosition))
                .containsExactly(0, 0);
    }
}
