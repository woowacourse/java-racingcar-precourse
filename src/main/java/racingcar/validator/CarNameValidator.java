package racingcar.validator;

public class CarNameValidator {
    private static final int ZERO = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(String name) {
        validateNameLengthZero(name);
        validateNameLengthLong(name);
    }

    private static void validateNameLengthZero(String name) {
        if (name.length() == ZERO) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 입력되지 않았습니다.");
        }
    }

    private static void validateNameLengthLong(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 지동차의 이름이 너무 깁니다. " + name);
        }
    }
}
