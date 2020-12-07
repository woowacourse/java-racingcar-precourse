package racingcar.domain;

import racingcar.validator.CarValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String racingCarNames) {
        CarValidator.validate(racingCarNames);
        this.cars = Arrays.stream(racingCarNames.split(CarValidator.DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void racing() {
        for (Car car: cars) {
            car.startTurn();
            car.printResult();
        }
        System.out.println();
    }

    public List<Car> getFastestCars() {
        Car fastestCar = cars.stream().max(Car::compareTo).orElseThrow(IllegalArgumentException::new);
        return cars.stream().filter(car -> car.isSamePosition(fastestCar)).collect(Collectors.toList());
    }
}
