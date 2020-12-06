package racingcar.exception;

public class RoundIllegalArgumentException extends RacingCarException {
    private static final String DEFAULT_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public RoundIllegalArgumentException() {
        super(DEFAULT_MESSAGE);
    }
}
