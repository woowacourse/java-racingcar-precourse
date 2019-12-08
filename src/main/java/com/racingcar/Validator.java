package com.racingcar;

import java.util.Iterator;
import java.util.List;

/**
 * Validator
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-06
 */

public class Validator {
    public static final int CAR_NAME_MAX_SIZE = 5;

    public boolean isValidName(List<String> input) {
        if (this.isNull(input) || input.size() == 0) {
            return false;
        }
        Iterator itr = input.iterator();
        while (itr.hasNext()) {
            String carName = (String) itr.next();
            if (hasBlank(carName) || isOverSize(carName)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidCount(int input) {
        if (this.isNull(input)) {
            return false;
        }
        if (!this.isPositiveNumber(input)) {
            return false;
        }
        return true;
    }

    public boolean hasBlank(String name) {
        return name.contains(" ");
    }

    public boolean isNull(Object input) {
        return input == null;
    }

    public boolean isOverSize(String name) {
        return name.length() > CAR_NAME_MAX_SIZE;
    }

    public boolean isPositiveNumber(int num) {
        return num > 0;
    }
}
