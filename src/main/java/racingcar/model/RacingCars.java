package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> pickWinner() {
        int maxPosition = racingCars.stream().mapToInt(Car::getPosition).max().getAsInt();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
