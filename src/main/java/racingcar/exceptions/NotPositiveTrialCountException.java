package racingcar.exceptions;

public class NotPositiveTrialCountException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 시도 횟수는 1 이상이어야 합니다. ";

    public NotPositiveTrialCountException() {
        super(MESSAGE);
    }
}
