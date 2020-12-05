package racingcar.service;

import racingcar.model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Constants.POSITION_INIT_VALUE;

public class WinnersFinder {

    private WinnersFinder() {
    }

    public static List<Car> find(List<Car> cars) {
        return findMaxPositionCars(findMaxPosition(cars), cars);
    }

    private static Integer findMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .min(Comparator.reverseOrder())
                .orElse(POSITION_INIT_VALUE);
    }

    private static List<Car> findMaxPositionCars(int maxPosition, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
