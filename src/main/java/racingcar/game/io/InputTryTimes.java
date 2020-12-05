package racingcar.game.io;

import java.util.Scanner;
import racingcar.game.io.error.TryTimeInputErrorHandler;
import racingcar.game.io.print.InputPrint;

public class InputTryTimes {
    private final TryTimeInputErrorHandler errorHandler;

    public InputTryTimes() {
        this.errorHandler = new TryTimeInputErrorHandler();
    }

    public int getInputFromUser(Scanner scanner) {
        String input;
        do {
            InputPrint.printMessageForInputTryTimes();
            input = scanner.nextLine();
        } while (!errorHandler.isValidInput(input));
        return Integer.parseInt(input);
    }
}
