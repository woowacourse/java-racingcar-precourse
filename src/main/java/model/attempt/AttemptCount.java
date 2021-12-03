package model.attempt;

public class AttemptCount {
    private static final String INTEGER_REGEX = "^[0-9]*$";
    private static final int MIN_ATTEMPT_VALUE = 1;
    private int value;

    public AttemptCount(final String value) {
        if (isNotInteger(value) || isNotPositiveNumber(value)) {
            throw new IllegalArgumentException("이동 횟수는 0 이상의 정수여야 합니다.");
        }
        this.value = Integer.parseInt(value);
    }

    private boolean isNotInteger(final String value) {
        return !value.matches(INTEGER_REGEX);
    }

    private boolean isNotPositiveNumber(final String value) {
        return Integer.parseInt(value) < MIN_ATTEMPT_VALUE;
    }
}
