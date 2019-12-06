package domain.car;

import domain.car.engine.FixEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("경주 참여 자동차 전체 전진")
    @Test
    void move() {
        Car answer1 = new Car("pci");
        Car answer2 = new Car("chan");
        answer1.move(new FixEngine(9));
        answer2.move(new FixEngine(9));
        RacingCars answerRacingCars = new RacingCars(Arrays.asList(answer1, answer2));

        Car car1 = new Car("pci");
        Car car2 = new Car("chan");
        RacingCars racingCars = new RacingCars(Arrays.asList(car1, car2));
        racingCars.move(new FixEngine(9));

        assertThat(racingCars).isEqualTo(answerRacingCars);
    }

    @DisplayName("우승 차량 찾기")
    @Test
    void getWinningCars() {
        Car car1 = new Car("pci");
        Car car2 = new Car("chan");
        RacingCars racingCars = new RacingCars(Arrays.asList(car1, car2));

        car1.move(new FixEngine(9));

        assertThat(racingCars.getWinningCars()).isEqualTo(new WinningCars(Arrays.asList(car1)));
    }
}