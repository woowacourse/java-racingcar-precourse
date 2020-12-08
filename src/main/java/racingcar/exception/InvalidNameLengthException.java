package racingcar.exception;

public class InvalidNameLengthException extends RacingCarException {
    private static final String DEFAULT_MESSAGE = "[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 한다.";

    public InvalidNameLengthException() {
        super(DEFAULT_MESSAGE);
    }
}
