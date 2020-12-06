package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class ParticipatingCars {
    private List<Car> cars;

    public ParticipatingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
