package racingcar.game;

import java.util.ArrayList;
import racingcar.Car;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }
}
