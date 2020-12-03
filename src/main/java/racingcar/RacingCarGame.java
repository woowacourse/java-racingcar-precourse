package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import utils.RandomUtils;

import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    private static final int RANGE_OF_NUMBER_ZERO = 0;
    private static final int RANGE_OF_NUMBER_NINE = 9;
    private static final int STATUS_MOVE = 4;
    private final InputController input;
    private final OutputController output;

    public RacingCarGame() {
        this.input = new InputController();
        this.output = new OutputController();
    }

    public void start(Scanner scanner) {
        List<String> participants = input.inputCarName(scanner);
        int tryCount = input.inputTryCount(scanner);
        Cars cars = new Cars(participants);
        playGame(cars, tryCount);
    }

    private void playGame(Cars cars, int tryCount) {
        int round = 0;
        output.printPlayGameMessage();
        while (round < tryCount) {
            moveOrStop(cars);
            output.printRoundResult(cars);
            round++;
        }
        output.printWinner(cars);
    }

    private void moveOrStop(Cars cars) {
        for (Car car : cars.getCars()) {
            isCarMoveOrStop(car);
        }
    }

    private void isCarMoveOrStop(Car car) {
        if (getRandomNumber() >= STATUS_MOVE) {
            car.move();
        }
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(RANGE_OF_NUMBER_ZERO, RANGE_OF_NUMBER_NINE);
    }
}