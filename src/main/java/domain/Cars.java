package domain;

import utils.InputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        cars = cars;
    }

    public static Cars makeCars(String carNames) {
        try {
            Stream<String> stream = Arrays.stream(carNames.split(","));
            List<Car> cars = stream.map(Car::new)
                    .collect(Collectors.toList());
            return new Cars(cars);
        } catch (IllegalArgumentException e) {
            return makeCars(InputUtils.inputCarNames());
        }
    }
}