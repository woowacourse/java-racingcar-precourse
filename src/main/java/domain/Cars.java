package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}