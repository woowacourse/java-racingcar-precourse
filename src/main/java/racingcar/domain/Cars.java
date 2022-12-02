package racingcar.domain;

import racingcar.Car;
import racingcar.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(TryCount tryCount) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            for (Car car : cars) {
                moveOrNot(car);
            }
        }
    }

    private void moveOrNot(Car car) {
        if (RandomNumberGenerator.generate() < 4) {
            return;
        }
        car.move();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car).append("\n");
        }
        return stringBuilder.toString();
    }
}
