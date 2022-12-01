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

    @Test
    void 우승자_판단_기능_단독_우승() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("testA"));
        cars.add(new Car("testB"));
        RacingCars racingCars = new RacingCars(cars);
        Car carA = racingCars.getRacingCars().get(0);
        Car carB = racingCars.getRacingCars().get(1);
        carA.forward();
        carA.forward();
        List<String> winners = racingCars.decideWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).contains("testA");
    }

    @Test
    void 우승자_판단_기능_공동_우승() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("testA"));
        cars.add(new Car("testB"));
        RacingCars racingCars = new RacingCars(cars);
        Car carA = racingCars.getRacingCars().get(0);
        Car carB = racingCars.getRacingCars().get(1);
        carA.forward();
        carB.forward();
        List<String> winners = racingCars.decideWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("testA");
        assertThat(winners).contains("testB");
    }
}