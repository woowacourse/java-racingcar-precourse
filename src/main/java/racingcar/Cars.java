package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private final String DELIMITER = ",";

    public Cars() {
    }

    public void createCars(String inputRacingCars) {
        cars = Arrays.stream(inputRacingCars.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
