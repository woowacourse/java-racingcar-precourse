package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public Car saveInOrder(Car car) {
        cars.add(car);
        return car;
    }

    public List<Car> findAllCarsInOrder() {
        return new ArrayList<>(cars);
    }
}
