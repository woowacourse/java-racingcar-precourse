package racingcar.model;

import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveForwardOrStop() {
        racingCars.forEach(Car::movePosition);
    }

    public void getRacingCarsInfo() {
        racingCars.forEach(Car::printCurrentInfo);
    }

    public void pickWinner() {
        // TODO: 최종 우승자 선별
   }
}
