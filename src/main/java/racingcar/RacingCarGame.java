package racingcar;

import racingcar.controller.InputController;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    private final InputController input;

    public RacingCarGame() {
        this.input = new InputController();
    }

    public void start(Scanner scanner) {
        List<String> participants = input.inputCarName(scanner);
        int tryCount = input.inputTryCount(scanner);
        Cars cars = new Cars(participants);
        playGame(cars, tryCount);
    }

    private void playGame(Cars cars, int tryCount) {

    }
}
