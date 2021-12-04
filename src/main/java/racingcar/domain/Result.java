package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private final List<Car> winners;

    public Result(List<Car> cars) {
        winners = findWinners(cars);
    }

    private List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
