package racingcar.validator;

import static racingcar.validator.ErrorCode.*;

public class RoundCountValidator {
    private static final int ONE = 1;

    public static int checkRoundCountAndReturn(String input) {
        isNull(input);
        isNumber(input);
        isPositiveAndLessThanMaxInteger(input);

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

    private static void isPositiveAndLessThanMaxInteger(String target) {
        if (isGreaterThanMaxInteger(target) || isLessThanOne(target))
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE.getDetail());
    }

    private static boolean isGreaterThanMaxInteger(String target) {
        long value = Long.parseLong(target);

        return value > Integer.MAX_VALUE;
    }

    private static boolean isLessThanOne(String target) {
        return Integer.parseInt(target) < ONE;
    }
}
