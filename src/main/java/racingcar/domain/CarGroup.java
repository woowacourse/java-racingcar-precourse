package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
