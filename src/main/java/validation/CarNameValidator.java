package validation;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) {

    }

    private static String[] splitCarName(String carName) {
        String carNames[] = carName.split(",");
        return carNames;
    }

    private static void validateCarNameCount(String carName) {

    }

    private static void validateCarNameLength(String carName) {

    }
}
