package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void carNameValidation(String[] cars) {
        isNotEmptyName(cars);
        isRightLength(cars);
        isNonDuplicate(cars);
    }

    public static void raceNumberValidation(String number) {
        isNumber(number);
        isPositiveInteger(number);
    }

    private static void isNotEmptyName(String[] cars) {
        for (String carName : cars) {
            if (carName.equals(Constant.EMPTY_NAME)) {
                throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_EMPTY);
            }
        }
    }

    private static void isRightLength(String[] cars) {
        for (String carName : cars) {
            if (carName.length() < Constant.MIN_CAR_NAME_LENGTH
                        || carName.length() > Constant.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_LENGTH);
            }
        }
    }

    private static void isNonDuplicate(String[] cars) {
        Set<String> carList = new HashSet<>();

        for (String carName : cars) {
            if (!carList.add(carName)) {
                throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_DUPLICATE);
            }
        }
    }

    private static void isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char num = number.charAt(i);

            if(!Character.isDigit(num)) {
                throw new IllegalArgumentException(Constant.ERROR_RACE_NUMBER);
            }
        }
    }

    private static void isPositiveInteger(String number) {
        int num = Integer.parseInt(number);

        if (num < Constant.MIN_RACE_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_RACE_NUMBER_POSITIVE_INTEGER);
        }
    }
}
