package racingcar.game.io.error;

import java.util.regex.Pattern;
import racingcar.game.io.error.print.TryTimeInputErrorPrint;

public class TryTimeInputErrorHandler {
    private static final int MAX_LENGTH_OF_TRY_TIMES_STRING = 2;
    private static final int MIN_TRY_TIMES = 1;
    private static final int MAX_TRY_TIMES = 10;
    private static final String ONLY_NUMBER_PATTERN = "^[0-9]+$";

    public boolean isValidInput(String input) {
        if (!isNumber(input)) {
            TryTimeInputErrorPrint.printNotNumberErrorMessage();
            return false;
        }
        if (!isCorrectRange(input)) {
            TryTimeInputErrorPrint.printInvalidRangeNumberErrorMessage();
            return false;
        }
        return true;
    }

    private boolean isCorrectRange(String input) {
        if (input.isEmpty()) {
            return false;
        }
        if (MAX_LENGTH_OF_TRY_TIMES_STRING < input.length()) {
            return false;
        }
        int tryTimes = Integer.parseInt(input);
        if (!(MIN_TRY_TIMES <= tryTimes && tryTimes <= MAX_TRY_TIMES)) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        return Pattern.matches(ONLY_NUMBER_PATTERN, input);
    }
}
