package racingcar.domain.car;

import racingcar.domain.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames, MovingStrategy movingStrategy) {
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());
        return new Cars(cars);
    }
}
