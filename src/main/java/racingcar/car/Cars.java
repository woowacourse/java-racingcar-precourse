package racingcar.car;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Cars {
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAMES_DELIMITER = ", ";
    private static final int DEFAULT_MAX_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> names, MovingPolicy movingPolicy) {
        this.cars = names.stream()
            .map(name -> new Car(name, movingPolicy))
            .collect(toList());
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