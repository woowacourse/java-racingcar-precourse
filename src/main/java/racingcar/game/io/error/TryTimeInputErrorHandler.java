package racingcar.game.io.error;

import java.util.regex.Pattern;

public class TryTimeInputErrorHandler {

    public boolean isValidInput(String input) {
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
        if (!(1 <= tryTimes && tryTimes <= 10)) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        String pattern = "^[0-9]+$";
        return Pattern.matches(pattern, input);
    }
}
