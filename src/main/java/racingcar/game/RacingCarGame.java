package racingcar.game;

import java.util.Scanner;
import racingcar.game.io.print.OutputPrint;
import racingcar.game.io.InputCarNames;
import racingcar.game.io.InputTryTimes;

public class RacingCarGame {
    private final Scanner scanner;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        InputCarNames inputCarNames = new InputCarNames();
        Cars cars = inputCarNames.getInputFromUserAndStore(scanner);

        InputTryTimes inputTryTimes = new InputTryTimes();
        int tryTimes = inputTryTimes.getInputFromUser(scanner);

        OutputPrint.printResultStartMessage();
        cars.startRacing(tryTimes);

        OutputPrint.printWinnerMessage();
        cars.findWinners();
    }
}
