/*
 * InputChecker.java
 * version 1.0
 * 2019.04.04
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package racingcar.util;

public class InputChecker {
    public static boolean checkCarName(String carName) {
        if (carName.length() > Constants.NAME_MAX_LENGTH) {
            System.out.println(Constants.WRONG_CAR_NAME_WARNING);
            return false;
        }
        if (carName.isEmpty()) {
            System.out.println(Constants.EMPTY_CAR_NAME_WARNING);
            return false;
        }
        return true;
    }

    public static boolean checkTrialNumber(int trial) {
        if (trial < Constants.NAME_MIN_TRIAL) {
            System.out.println(Constants.WRONG_TRIAL_NUMBER_WARNING);
            return false;
        }
        return true;
    }
}
