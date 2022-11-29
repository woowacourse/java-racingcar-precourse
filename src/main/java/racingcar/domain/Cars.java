package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void play(NumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate()));
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

    private void validate(List<Car> cars) {
        if (hasDuplicateName(cars)) {
            throw new IllegalArgumentException("중복된 이름은 포함될 수 없습니다.");
        }
    }

    private boolean hasDuplicateName(List<Car> cars) {
        return IntStream.range(0, cars.size() - 1)
                .anyMatch(idx -> cars.get(idx).isSameName(cars.get(idx + 1)));
    }
}
