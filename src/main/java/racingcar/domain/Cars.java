package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.RandomNumberGenerator;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(RandomNumberGenerator generator) {
        cars.stream()
                .forEach(car -> car.move(generator.generate()));
    }

    public List<Car> getWinners() {
        int maximum = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
        return cars.stream()
                .filter(car -> car.getPosition() == maximum)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
