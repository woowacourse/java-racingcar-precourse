package racingcar.domains.output;

import racingcar.domains.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult implements Output {
    private static final String WINNER_PRINT_PREFIX = "최종 우승자: ";

    private List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void print() {
        System.out.println(WINNER_PRINT_PREFIX
                + String.join(", ", getWinnerName()));
    }

    private List<String> getWinnerName() {
        return getWinner().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getWinner() {
        Car mostMovedCar = getMostMoved();

        return cars.stream().
                filter(car -> mostMovedCar.isSamePosition(car))
                .collect(Collectors.toList());
    }

    private Car getMostMoved() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }
}
