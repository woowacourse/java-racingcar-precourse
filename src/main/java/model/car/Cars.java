package model.car;

import java.util.List;
import java.util.stream.Collectors;

import model.movement.Movement;

public class Cars {
    private static final int MIN_NUMBER_OF_CARS = 2;
    private final List<Car> values;

    public Cars(final List<String> carNames) {
        validateMinSize(carNames);
        validateOverlap(carNames);
        values = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateOverlap(final List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("이름들 간에 중복이 있습니다.");
        }
    }

    private void validateMinSize(final List<String> carNames) {
        if(carNames.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("자동차는 최소 2개가 필요합니다.");
        }
    }

    public void race(final Movement movement) {
        values.forEach(car -> car.move(movement.canMove()));
    }

    public List<Car> getAttemptResult() {
        return values;
    }

    public List<Car> getWinners() {
        return values.stream()
                .filter(this::hasHighestPosition)
                .collect(Collectors.toList());
    }

    private boolean hasHighestPosition(final Car car) {
        return values.stream()
                .filter(another -> !car.equals(another))
                .allMatch(car::hasHigherPositionThan);
    }
}
