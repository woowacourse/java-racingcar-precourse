package racingcar;

import java.util.Scanner;

public class RacingCarGame {

    private final InputView inputView;

    RacingCarGame(Scanner scanner) {
        inputView = new InputView(scanner);
    }


    public void runGame() {
        Car[] cars = inputView.getCars();
        int trial = inputView.getTrials();
    }
}
