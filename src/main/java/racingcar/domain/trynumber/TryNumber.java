package racingcar.domain.trynumber;

public class TryNumber {
    private static final String TRY_NUMBER_NOT_SMALLER_THAN_MIN_TRY_NUMBER_MESSAGE = "1보다 작은 값은 입력할 수 없습니다.";
    private static final int MIN_TRY_NUMBER = 1;

    private final int tryNumber;

    public TryNumber(int tryNumber) {
        validateTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void validateTryNumber(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(TRY_NUMBER_NOT_SMALLER_THAN_MIN_TRY_NUMBER_MESSAGE);
        }
    }

    public int getValue() {
        return tryNumber;
    }
}
