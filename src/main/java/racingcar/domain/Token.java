package racingcar.domain;

public class Token {
    public static final String ERROR_STRING = "[ERROR]";
    public static final String ERROR_NULL_MENTION = ERROR_STRING + " 값을 입력해주세요.";
    public static final String ERROR_TYPE_MENTION = ERROR_STRING + " 시도 횟수는 숫자여야 한다.";
    public static final int ITERATION_MODIFIER = -1;
    public static final String EMPTY_STRING = "";

    private int count;

    private Token(String value) {
        checkValidation(value);
        this.count = Integer.parseInt(value.trim());
    }

    public static Token from(String value) {
        return new Token(value);
    }

    private void checkValidation(String value) {
        checkNull(value);
        checkEmpty(value.trim());
        checkType(value.trim());
    }

    private void checkEmpty(String value) {
        if (isEmpty(value)) {
            throw new IllegalArgumentException(ERROR_NULL_MENTION);
        }
    }

    private boolean isEmpty(String value) {
        return EMPTY_STRING.equals(value);
    }

    private void checkType(String value) {
        if (!isDigit(value)) {
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

    public boolean hasNext() {
        count--;
        return count > ITERATION_MODIFIER;
    }

}
