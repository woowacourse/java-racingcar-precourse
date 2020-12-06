package racingcar.model;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int THRESHOLD = 3;
    private static final String CAR_NAME_DELIMITER = ",";

    private List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    private void createCar(String carNames) {
        for (String carName : carNames.split(CAR_NAME_DELIMITER)) {
            cars.add(new Car(carName));
        }
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private void tryToMoveCar() {
        for (Car car : cars) {
            if (generateRandomNumber() > THRESHOLD) {
                car.moveForward();
            }
        }
    }
}
