package racingcar;

public class Validator {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MINIMUM_COUNT = 0;
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void validateCarName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + ExceptionMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    public static void validateCountInputFormat(String inputCount) {

        for (int i = 0 ; i < inputCount.length() ; i++) {
            if (!Character.isDigit(inputCount.charAt(i))) {
                throw new IllegalArgumentException(ERROR_PREFIX + ExceptionMessage.COUNT_MUST_BE_POSITIVE_INTEGER.getMessage());
            }
        }
    }

    public static void validateCount(int count) {
        if (count <= MINIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + ExceptionMessage.COUNT_MUST_GRATER_THAN_ZERO.getMessage());
        }
    }
}
