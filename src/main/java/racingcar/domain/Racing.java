package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;

    private static final String NEW_LINE = "\n";

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing create(String... names) {

        List<Car> cars = createCars(names);

        return new Racing(cars);
    }

    private static List<Car> createCars(String... names) {

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(Car.createNameBy(name.trim()));
        }
        return cars;
    }

    public void moveCars() {
        cars.stream().forEach(Car::move);
    }

    public List<Car> getWinners() {
        Car firstCar = getFirstCar();
        List<Car> winners = cars.stream()
                .filter(car -> car.atFirstPosition(firstCar))
                .collect(Collectors.toList());

        return toUnmodifiable(winners);
    }

    private List<Car> toUnmodifiable(List<Car> winners) {
        return Collections.unmodifiableList(winners);
    }

    /*
     * 해당 메서드는 다른 객체에게 노출 금지
     * */
    private Car getFirstCar() {
        return Collections.max(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return Objects.equals(cars, racing.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car.getCurrentPosition())
                .collect(Collectors.joining(NEW_LINE));
    }
}
