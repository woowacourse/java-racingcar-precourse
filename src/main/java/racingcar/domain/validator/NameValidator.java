/*
 * NameValidator.java
 *
 * version 1.0
 *
 * 2020/12/07
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package racingcar.domain.validator;

import java.util.ArrayList;

public class NameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static boolean isOutOfRange(final ArrayList<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicated(final ArrayList<String> carNames) {
        final ArrayList<String> nameList = new ArrayList<>();

        for (String name : carNames) {
            if (nameList.contains(name)) {
                return true;
            }
            nameList.add(name);
        }
        return false;
    }

    public static boolean isEmpty(final ArrayList<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
