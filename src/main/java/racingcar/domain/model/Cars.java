package racingcar.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.utils.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void play(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCar(maxPositionCar);
    }

    private List<Car> findSamePositionCar(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
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
