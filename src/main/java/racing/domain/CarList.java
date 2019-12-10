package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {
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
}
