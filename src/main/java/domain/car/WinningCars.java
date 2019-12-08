package domain.car;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class WinningCars {
    private final List<Car> cars;

    public WinningCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnersName() {
        return cars.stream()
                .map(Car::getName)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCars that = (WinningCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
