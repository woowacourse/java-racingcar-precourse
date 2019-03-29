package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    public static String joinCarNames(List<Car> cars, String delimiter) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
