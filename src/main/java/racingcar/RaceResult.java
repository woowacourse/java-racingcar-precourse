package racingcar;

import domain.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private static List<Car> cars;

    public static List<String> getResult(List<Car> inputCars) {
        cars = inputCars;
        return getWinnerName();
    }

    private static List<String> getWinnerName() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }

}
