package racingcar.domain;

public class Token {
    public static final String ERROR_NULL_MENTION = "[ERROR] 입력값이 null입니다.";
    public static final String ERROR_TYPE_MENTION = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private final int count;

    private Token(String value) {
        checkValidation(value);
        count = Integer.parseInt(value);
    }

    private void checkValidation(String value) {
        checkNull(value);
        checkType(value);
    }

    private void checkType(String value) {
        if ( !isDigit(value)) {
            throw new IllegalArgumentException(ERROR_TYPE_MENTION);
        }
    }

    private boolean isDigit(String value) {
        return value.chars().allMatch(Character::isDigit);
    }

    private void checkNull(String value) {
        if (isNull(value)) {
            throw new IllegalArgumentException(ERROR_NULL_MENTION);
        }
    }

    private boolean isNull(String value) {
        return null == value;
    }

    public static Token from(String value) {
        return new Token(value);
    }
}
