/*
 * CountValidator.java
 *
 * version 1.1
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain.validator;

public class CountValidator {
    private static final int MIN_COUNT = 1;

    public static boolean isCountZero(final String input) {
        if (Integer.parseInt(input) > MIN_COUNT) {
            return true;
        }
        return false;
    }

    public static void checkNumeric(final String input, final String message) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
