/*
 * @(#)ValidatorImpl.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package domain;

import java.util.Arrays;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateNames(String[] names) {
        if (names.length < RacingGameConfig.MIN_NAMES) {
            return false;
        }

        for (String name : names) {
            if (!isValidName(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidName(String name) {
        if (RacingGameConfig.MAX_NAME_LENGTH < name.length()) {
            return false;
        }

        return Arrays.stream(RacingGameConfig.NOT_ALLOWED_IN_NAME).parallel().noneMatch(name::contains);
    }

    @Override
    public boolean validateCycles(int cycles) {
        return RacingGameConfig.MIN_CYCLES <= cycles;
    }
}
