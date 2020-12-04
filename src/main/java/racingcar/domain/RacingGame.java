package racingcar.domain;

import racingcar.domain.strategies.CarMovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<String> carNames, CarMovingStrategy movingStrategy) {
        createCars(carNames, movingStrategy);
    }

    private void createCars(List<String> carNames, CarMovingStrategy movingStrategy) {
        cars = new ArrayList<>();
        carNames.forEach((carName) -> cars.add(new Car(carName, movingStrategy)));
    }

    public void playOneCycle() {
        cars.forEach(Car::go);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
