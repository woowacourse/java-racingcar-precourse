package racingcar;

import ui.Input;
import ui.Output;

import java.util.Scanner;

public class Game {
    public void start(Scanner scanner) {
        String carNamesInput = Input.receiveRacingCarNames(scanner);
        String[] carNames = carNamesInput.split(",");

        String attemptsCountInput = Input.receiveAttemptsCount(scanner);
        int attemptsCount = Integer.parseInt(attemptsCountInput);

        Output.willPrintResult();
    }
}
