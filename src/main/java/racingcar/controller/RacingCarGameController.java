package racingcar.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import utils.RandomUtils;

public class RacingCarGameController {

    private static final int MOVE_CONDITION_NUM = 4;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int MIN_RANDOM_NUM = 0;
    private static InputView inputView;
    private static OutputView outputView;
    private int maxPosition = 0;
    private int raceCount;
    private List<Car> cars = new LinkedList<>();

    public RacingCarGameController(Scanner scanner) {
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    private void setCars() {
        cars = inputView.getCars();
    }

    private void setRaceCount() {
        raceCount = inputView.getRaceCount();
    }

    private void race() {
        for (Car car : cars) {
            if (RandomUtils.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM) >= MOVE_CONDITION_NUM) {
                int carPosition = car.move();
                maxPosition = Math.max(maxPosition, carPosition);
            }
        }
    }

    private List<Car> makeWinners() {
        List<Car> winners = new LinkedList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void start() {
        setCars();
        setRaceCount();
        outputView.printRacingResultMessage();
        for (int i = 0; i < raceCount; i++) {
            race();
            outputView.printCarsStatus(cars);
        }
        outputView.printCarNames(makeWinners());
    }

}
