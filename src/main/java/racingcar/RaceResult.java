package racingcar;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    public static List<String> getWinnerName(List<Car> inputCars) {
        int maxPosition = getMaxPosition(inputCars);
        return inputCars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> inputCars) {
        return inputCars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }

}
