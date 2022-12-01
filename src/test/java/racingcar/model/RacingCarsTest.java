package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    void 경주할_자동차_생성_기능() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a1"));
        cars.add(new Car("a2"));
        cars.add(new Car("a3"));
        RacingCars racingCars = new RacingCars(cars);

        assertThat(racingCars.getRacingCars()).isEqualTo(cars);
    }
}