package racingcar.domain.race.exception;

public class InvalidMovingCountInputException extends IllegalArgumentException {

    private static final String MESSAGE =
        "[ERROR] 시도 횟수는 숫자여야 합니다. 그리고 숫자는 0보다 커야합니다. (입력 값: '%s')";

    public InvalidMovingCountInputException(final int input) {
        super(String.format(MESSAGE, input));
    }

    public InvalidMovingCountInputException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
