package racingcar.domain;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    private final String carNames;

    public CarGenerator(String carNames) {
        this.carNames = carNames;
    }

    public List<Car> generateNamesToCars() {
        return Arrays.stream(carNames.split(","))
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());
    }
}
