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
}
