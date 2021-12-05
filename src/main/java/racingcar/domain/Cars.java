package racingcar.domain;

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

    public List<String> getWinner() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
            .filter(car -> car.position() == maxPosition)
            .map(Car::name)
            .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.position());
        }
        return maxPosition;
    }
}
