package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Car> makeCarObject(String[] allCarName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars
    }
}
