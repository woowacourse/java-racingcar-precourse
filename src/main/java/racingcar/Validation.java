package racingcar;

public class Validation {
    public static boolean carNameValidation(String[] cars) {
        return isNotEmptyName(cars);
    }

    private static boolean isNotEmptyName(String[] cars) {
        for (String carName : cars) {
            if (carName.equals(Constant.EMPTY_NAME)) {
                return false;
            }
        }
        return true;
    }
}
