package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createRandomCars(List<String> names) {
        List<Car> cars = names.stream()
            .map(Car::createRandomMoveCar)
            .collect(Collectors.toList());
        return new Cars(cars);
    }

}
