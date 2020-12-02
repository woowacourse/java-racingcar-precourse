package racingcar;

import java.util.List;
import utils.RandomUtils;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
public class RacingGame {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_RANGE, END_RANGE);
    }
}
