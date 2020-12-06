package racingcar.exception;

public class SpaceInputException extends RacingCarException {
    private static final String DEFAULT_MESSAGE = "[ERROR] 입력 값은 공백이 아니여야 한다.";

    public SpaceInputException() {
        super(DEFAULT_MESSAGE);
    }
}
