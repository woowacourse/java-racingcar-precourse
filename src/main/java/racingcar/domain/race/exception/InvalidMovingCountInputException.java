package racingcar.domain.race.exception;

public class InvalidMovingCountInputException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 시도할 회수는 0보다 큰 숫자를 입력해야 합니다. (입력 값: '%s')";

    public InvalidMovingCountInputException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
