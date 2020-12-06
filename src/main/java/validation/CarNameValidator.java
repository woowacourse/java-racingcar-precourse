package validation;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) {
        String carNames[] = splitCarName(carName);
        validateCarNameCount(carNames);
    }

    private static String[] splitCarName(String carName) {
        String carNames[] = carName.split(",");
        return carNames;
    }

    private static void validateCarNameCount(String[] carName) {
        if (carName.length == 1) {
            throw new IllegalArgumentException("경주할 자동차는 한 대 이상이어야 합니다.");
        }
    }

    private static void validateCarNameLength(String[] carName) {

    }
}
