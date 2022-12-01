package racingcar.model;

import racingcar.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private static final int MIN_FORWARD_NUMBER = 4;

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void forwardTry() {
        for (Car racingCar : racingCars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= MIN_FORWARD_NUMBER) {
                racingCar.forward();
            }
        }
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
