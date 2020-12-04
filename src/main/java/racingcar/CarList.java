package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.RandomUtils;

public class CarList {
    private static final int RANDOM_MINIMUM = 1;
    private static final int RANDOM_MAXIMUM = 9;

    private List<Car> cars;

    public CarList(String[] carNames) {
        cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.attemptToMove(getRandomValue());
        }
    }
    
    private int getRandomValue() {
        return RandomUtils.nextInt(RANDOM_MINIMUM, RANDOM_MAXIMUM);
    }
}
