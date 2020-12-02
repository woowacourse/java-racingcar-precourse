package racingcar.domain.race.exception;

public class EmptyCarNameInputException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 경주 할 자동차 이름이 비어 있습니다. (입력 값: '%s')";

    public EmptyCarNameInputException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
