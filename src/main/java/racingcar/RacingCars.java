package racingcar;

import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveFor(int roundCount) {
        for (int i = 0; i < roundCount; ++i) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.forEach(Car::move);
    }

    public void printResult() {
        cars.forEach(System.out::println);
    }
}
