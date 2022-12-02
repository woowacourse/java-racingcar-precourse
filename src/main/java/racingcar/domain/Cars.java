package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void move() {
        for (Car car : cars) {
            if (RandomNumberGenerator.generate() >= 4) {
                car.move();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car).append("\n");
        }
        return result.toString();
    }

    public List<String> winners() {
        int highScore = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() >= highScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
