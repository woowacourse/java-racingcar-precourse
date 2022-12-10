package racingcar.domain;

import racingcar.support.CarMoveFlagGenerator;
import racingcar.support.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class CarGroup {

    private final RandomNumberGenerator flagGenerator;
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
        this.flagGenerator = new CarMoveFlagGenerator();
    }

    public void moveAll() {
        cars.stream()
                .filter(car -> flagGenerator.generate())
                .forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
