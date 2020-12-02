package racingcar.game;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputTryTimes {
    private final UserTryTimeInputErrorHandler errorHandler;

    public UserInputTryTimes() {
        this.errorHandler = new UserTryTimeInputErrorHandler();
    }

    public void getInputFromUser(Scanner scanner) {
        String input;
        do {
            InputPrint.printMessageForInputTryTimes();
            input = scanner.nextLine();
        } while (!isValidInput(input));

    }

    private boolean isValidInput(String input) {
        if (!isNumber(input)) {
            errorHandler.printNotNumberErrorMessage();
            return false;
        }
        if (!isCorrectRange(input)) {
            errorHandler.printInvalidRangeNumberErrorMessage();
            return false;
        }
        return true;
    }

    private boolean isCorrectRange(String input) {
        if (input.isEmpty()) {
            return false;
        }
        if (5 < input.length()) {
            return false;
        }
        int tryTimes = Integer.parseInt(input);
        if (!(1 <= tryTimes && tryTimes <= 1000)) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        String pattern = "^[0-9]+$";
        return Pattern.matches(pattern, input);
    }
}
