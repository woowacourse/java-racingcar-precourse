package racingcar.controller;

import java.util.LinkedList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import utils.RandomUtils;

public class RacingCarGameController {

    private static final int MOVE_CONDITION_NUM = 4;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int MIN_RANDOM_NUM = 0;
    private static int maxPosition = 0;
    private static int raceCount;
    private static List<Car> cars = new LinkedList<>();

    private static void setCars() {
        cars = InputView.getCars();
    }

    private static void setRaceCount() {
        raceCount = InputView.getRaceCount();
    }

    private static void race() {
        for (Car car : cars) {
            if (RandomUtils.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM) >= MOVE_CONDITION_NUM) {
                int carPosition = car.move();
                maxPosition = Math.max(maxPosition, carPosition);
            }
        }
    }

    private static List<Car> makeWinners() {
        List<Car> winners = new LinkedList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static void start() {
        setCars();
        setRaceCount();
        OutputView.printRacingResultMessage();
        for (int i = 0; i < raceCount; i++) {
            race();
            OutputView.printCarsStatus(cars);
        }
        OutputView.printCarNames(makeWinners());
    }

}
