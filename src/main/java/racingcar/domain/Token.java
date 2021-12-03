package racingcar.domain;

public class Token {
    public static final int ITERATION_MODIFIER = -1;
    public static final String EMPTY_STRING = "";
    public static final int THRESHOLD_NUMBER = 1;

    public static final String ERROR_STRING = "[ERROR]";
    public static final String ERROR_NULL_MENTION = ERROR_STRING + " 값을 입력해주세요.";
    public static final String ERROR_TYPE_MENTION = ERROR_STRING + " 시도 횟수는 숫자여야 한다.";
    public static final String ERROR_LESS_THAN_THRESHOLD_MENTION = ERROR_STRING + " 입력값은 "
        + THRESHOLD_NUMBER + " 이상이어야 합니다.";

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
        checkLessThanThreshold(value.trim());
    }

    private void checkLessThanThreshold(String value) {
        if(isLessThanThreshold(value)){
            throw new IllegalArgumentException(ERROR_LESS_THAN_THRESHOLD_MENTION);
        }
    }

    private boolean isLessThanThreshold(String value) {
        return Integer.parseInt(value) < THRESHOLD_NUMBER;
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
