package racingcar.car;

import racingcar.Constant;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidation {
    public static void validation(String[] cars) {
        isNotEmptyName(cars);
        isRightLength(cars);
        isNonDuplicate(cars);
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
}
