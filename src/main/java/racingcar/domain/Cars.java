package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.CarNameDuplicateException;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createRandomCars(List<String> names) {
        List<Car> cars = names.stream()
            .map(Car::createRandomMoveCar)
            .collect(Collectors.toList());
        checkDuplicateName(names);
        return new Cars(cars);
    }

    private static void checkDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new CarNameDuplicateException();
        }
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
            .filter(car -> isWinnerPosition(maxPosition, car))
            .map(Car::name)
            .collect(Collectors.toList());
    }

    private boolean isWinnerPosition(int maxPosition, Car car) {
        return car.position() == maxPosition;
    }

    private int calculateMaxPosition() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::position))
            .get().position();
    }
}
