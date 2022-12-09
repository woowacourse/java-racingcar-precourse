package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race(Number generator) {
        for (Car car : cars) {
            car.tryMoveForward(generator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
