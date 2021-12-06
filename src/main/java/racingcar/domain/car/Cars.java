package racingcar.domain.car;

import static java.util.stream.Collectors.*;
import static racingcar.domain.error.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAMES_DELIMITER = ", ";
    private static final int DEFAULT_MAX_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> names, MovingPolicy movingPolicy) {
        List<Car> cars = names.stream()
            .map(name -> new Car(name, movingPolicy))
            .collect(toList());
        validateDuplicate(names);
        this.cars = cars;
    }

    private void validateDuplicate(List<String> names) {
        int originalSize = names.size();
        Set<String> noneDuplicatedNames = new HashSet<>(names);
        if (originalSize != noneDuplicatedNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_NOT_DUPLICATE.getMessage());
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String getExecutionResult() {
        return cars.stream()
            .map(Car::getStateMessage)
            .collect(joining(NEW_LINE));
    }

    public String getWinnersNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(joining(WINNER_NAMES_DELIMITER));
    }

    private int getMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .reduce(DEFAULT_MAX_POSITION, Integer::max);
    }
}