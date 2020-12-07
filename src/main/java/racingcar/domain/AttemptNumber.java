package racingcar.domain;

public class AttemptNumber {
    private static final int MAX_ATTEMPT_NUMBER = 100;
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private int attemptNumber;

    public AttemptNumber(String attemptNumber) {
        validate(attemptNumber);
        this.attemptNumber = Integer.parseInt(attemptNumber);
    }

    private void validate(String attemptNumber) {
        validateCorrectNumber(attemptNumber);
        validateNumberRange(attemptNumber);
    }

    private void validateCorrectNumber(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateNumberRange(String attemptNumber) {
        int convertedAttemptNumber = Integer.parseInt(attemptNumber);
        if (convertedAttemptNumber < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MIN_ATTEMPT_NUMBER + "이상의 숫자여야 합니다.");
        }
        if (convertedAttemptNumber > MAX_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MAX_ATTEMPT_NUMBER + "이하의 숫자여야 합니다.");
        }
    }

    public boolean isRemain() {
        return attemptNumber > ZERO;
    }

    public void decrease() {
        minus(ONE);
    }

    private void minus(int number) {
        attemptNumber -= number;
    }
}
