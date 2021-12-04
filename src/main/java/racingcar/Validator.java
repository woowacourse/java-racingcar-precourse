package racingcar;

public class Validator {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void validateCarName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + ExceptionMessage.TOO_LONG_CAR_NAME.getMessage());
        }
    }

    public static void validateCountInputFormat(String inputCount) {

        for (int i = 0 ; i < inputCount.length() ; i++) {
            if (!Character.isDigit(inputCount.charAt(i))) {
                throw new IllegalArgumentException(ERROR_PREFIX + ExceptionMessage.COUNT_MUST_BE_INTEGER.getMessage());
            }
        }
    }
}
