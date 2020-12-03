package racingcar;

public class Validation {
    public static boolean carNameValidation(String[] cars) {
        return isNotEmptyName(cars) && isRightLength(cars);
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
}
