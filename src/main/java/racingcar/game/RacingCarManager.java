package racingcar.game;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private static final int MAX_LEN_CAR_NAME = 5;

    private final List<Car> racingCarList;

    public RacingCarManager(List<String> carNameList) {
        this.racingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            this.racingCarList.add(this.makeValidateCar(carName));
        }
    }

    private Car makeValidateCar(String carName) {
        if (carName.length() <= MAX_LEN_CAR_NAME) {
            return new Car(carName);
        }

        throw new IllegalArgumentException();
    }
}
