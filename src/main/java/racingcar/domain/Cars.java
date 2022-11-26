package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.RandomNumberGenerator;
import racingcar.dto.WinnerDto;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(RandomNumberGenerator generator) {
        cars.stream()
                .forEach(car -> car.move(generator.generate()));
    }

    public Cars getWinners() {
        int maximum = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maximum)
                .collect(Collectors.toList());
        return new Cars(winners);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
