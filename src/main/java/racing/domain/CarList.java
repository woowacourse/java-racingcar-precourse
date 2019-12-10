package racing.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CarList implements Iterable<Car> {
    private final List<Car> cars;

    private CarList(List<Car> cars) {
        this.cars = cars;
    }

    public static CarList getByNames(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new CarList(cars);
    }

    public void playOneRoundWith(CarRunRule runRule) {
        cars.stream()
                .filter(car -> runRule.canRun())
                .forEach(Car::run);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public Winner getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> maxPositionCars = cars.stream()
                .filter(car -> car.isPosition(maxPosition))
                .collect(Collectors.toList());

        return Winner.of(maxPositionCars);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
