/*
 * CountValidator.java
 *
 * version 1.0
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain.validator;

public class CountValidator {

    public static boolean isNumber(final String input) {
        if (Integer.parseInt(input) > 0) {
            return true;
        }
        return false;
    }
}
