package racingcar.exception;

public class NameDuplicationException extends RacingCarException {
    private static final String DEFAULT_MESSAGE = "[ERROR] 자동차의 이름은 중복되지 않아야 한다.";

    public NameDuplicationException() {
        super(DEFAULT_MESSAGE);
    }
}
