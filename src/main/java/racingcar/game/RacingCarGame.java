package racingcar.game;

import java.util.Scanner;

public class RacingCarGame {
    private final Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();
        userInputCarNames.getInputFromUser(scanner);
        UserInputTryTimes userInputTryTimes = new UserInputTryTimes();
        userInputTryTimes.getInputFromUser(scanner);
    }
}
