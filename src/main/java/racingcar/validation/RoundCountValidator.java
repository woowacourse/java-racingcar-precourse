package racingcar.validation;

import static racingcar.validation.ErrorCode.*;

public class RoundCountValidator {
    private static final int ZERO = 0;

    public static int checkRoundCountAndReturn(String input) {
        isNull(input);
        isNumber(input);
        isZero(input);

        return Integer.parseInt(input);
    }

    private static void isNull(String input) {
        if (input.isEmpty())
            throw new IllegalArgumentException(IS_NULL.getDetail());
    }

    private static void isNumber(String target) {
        for (char each : target.toCharArray()) {
            validateNumber(each);
        }
    }

    private static void validateNumber(char each) {
        if (!Character.isDigit(each))
            throw new IllegalArgumentException(FOUND_NOT_NUMBER.getDetail());
    }

    private static void isZero(String target) {
        if (Integer.parseInt(target) == ZERO)
            throw new IllegalArgumentException(FOUND_ZERO_ONLY.getDetail());
    }
}
