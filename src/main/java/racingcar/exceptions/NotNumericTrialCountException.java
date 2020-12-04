package racingcar.exceptions;

public class NotNumericTrialCountException extends IllegalArgumentException {
    private static final String message = "[ERROR] 시도 횟수는 정수형으로 입력해야 합니다. ";

    public NotNumericTrialCountException() {
        super(message);
    }
}
