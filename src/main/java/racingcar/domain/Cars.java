package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
