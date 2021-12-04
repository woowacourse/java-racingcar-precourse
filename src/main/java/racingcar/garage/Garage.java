package racingcar.garage;

import racingcar.Car;

import java.util.Set;

public class Garage {
    private final Set<Car> carSet;

    public Garage(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public static Garage from(Set<Car> carSet) {
        return new Garage(carSet);
    }

    public boolean containsCar(Car car) {
        return carSet.contains(car);
    }
}
