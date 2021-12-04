package racingcar.validator;

import static util.CarConstant.*;

public class NumberValidator {

    public static void isRightTryNumber(String input) {
        isNumber(input);
        isRightRange(input);
    }

    private static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + " " + TRY_NUMBER_NOT_NUMBER_MESSAGE);
        }
    }

    private static void isRightRange(String input) {
        int inputNum = Integer.parseInt(input);
        if (inputNum <= ZERO) {
            throw new IllegalArgumentException(ERROR_PREFIX + " " + NUMBER_OUT_OF_RANGE_MESSAGE);
        }
    }
}
