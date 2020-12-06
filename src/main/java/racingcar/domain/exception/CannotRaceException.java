package racingcar.domain.exception;

public class CannotRaceException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수를 초과했기 때문에 경주를 진행할 수 없습니다.";

    public CannotRaceException() {
        super(ERROR_MESSAGE);
    }
}
