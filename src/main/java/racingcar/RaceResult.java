package racingcar;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private static List<Car> cars;

    public static List<Car> getResult(List<Car> inputCars) {
        cars = inputCars;
        return getWinnerCar();
    }

    private static List<Car> getWinnerCar() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }

}
