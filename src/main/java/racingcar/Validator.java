package racingcar;

public class Validator {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static void validateCarName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차의 이름은 5자 이하여야합니다.");
        }
    }
}
