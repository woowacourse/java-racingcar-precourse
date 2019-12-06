package domain.car;

import domain.car.engine.Engine;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int NOBODY_MOVE = 0;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(Engine engine) {
        cars.forEach(car -> car.move(engine));
    }

    public WinningCars getWinningCars() {
        int maxPosition = findMaxPosition();
        List<Car> winners = findWinners(maxPosition);

        return new WinningCars(winners);
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(NOBODY_MOVE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
