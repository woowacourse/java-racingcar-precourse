package racingcar.exception;

public class InputWithoutNameException extends RacingCarException{
    private static final String DEFAULT_MESSAGE = "[ERROR] 자동차의 이름 값을 입력해야 한다.";

    public InputWithoutNameException() {
        super(DEFAULT_MESSAGE);
    }
}
