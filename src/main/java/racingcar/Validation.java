package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static boolean carNameValidation(String[] cars) {
        return isNotEmptyName(cars) && isRightLength(cars)
                    && isNonDuplicate(cars);
    }

    public static boolean raceNumberValidation(String number) {
        return isNumber(number);
    }

    private static boolean isNotEmptyName(String[] cars) {
        for (String carName : cars) {
            if (carName.equals(Constant.EMPTY_NAME)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRightLength(String[] cars) {
        for (String carName : cars) {
            if (carName.length() < Constant.MIN_CAR_NAME_LENGTH
                        || carName.length() > Constant.MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNonDuplicate(String[] cars) {
        Set<String> carList = new HashSet<>();

        for (String carName : cars) {
            if (!carList.add(carName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char num = number.charAt(i);

            if(!Character.isDigit(num)) {
                return false;
            }
        }
        return true;
    }
}
