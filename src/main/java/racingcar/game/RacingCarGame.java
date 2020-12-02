package racingcar.game;

import java.util.Scanner;

public class RacingCarGame {
    private final Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();
        Cars cars = userInputCarNames.getInputFromUser(scanner);
        UserInputTryTimes userInputTryTimes = new UserInputTryTimes();
        int tryTimes = userInputTryTimes.getInputFromUser(scanner);
        OutputPrint.printResultStartMessage();
        cars.startRacing(tryTimes);
    }
}
