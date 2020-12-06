package racingcar.exceptions;

public class TooLongCarNameException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 자동차 이름은 5글자 이하이어야 합니다. ";

    public TooLongCarNameException() {
        super(MESSAGE);
    }
}
