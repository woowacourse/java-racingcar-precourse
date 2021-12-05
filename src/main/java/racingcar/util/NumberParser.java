package racingcar.util;

import static racingcar.error.ErrorMessage.*;

public class NumberParser {
    private NumberParser() {}

    public static int parseInt(String string) {
        if (string.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(string);
        }
        throw new IllegalArgumentException(NOT_NUMBER.getMessage());
    }
}
