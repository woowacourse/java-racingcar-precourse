package racingcar;

import static racingcar.Rule.END_RANGE;
import static racingcar.Rule.START_RANGE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomUtils;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
public class RacingGame {
    private static final int FIRST_CAR = 0;
    private static final String RESULT_MESSAGE = "\n실행 결과";

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int gameCount) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < gameCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
            System.out.println(car);
        }
        System.out.println();
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_RANGE, END_RANGE);
    }

    public List<String> findWinners() {
        return findCoWinners(getWinner());
    }

    private Car getWinner() {
        Collections.sort(cars);
        return cars.get(FIRST_CAR);
    }

    private List<String> findCoWinners(Car winner) {
        return cars.stream()
                   .filter(winner::equalsPosition)
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }
}
