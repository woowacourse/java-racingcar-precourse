package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    private static class InnerInstanceClazz {
        private static final CarRepository instance = new CarRepository();
    }

    public static CarRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCar(Car car) {
        cars.add(car);
    }

    public int getCarCount() {
        return cars.size();
    }

    public void moveForward(int index) {
        cars.get(index).moveForward();
    }
}