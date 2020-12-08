package racingcar.domain.exception;

public class CannotFindWinnerCarException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 우승 차량을 찾을 수 없습니다.";

    public CannotFindWinnerCarException() {
        super(ERROR_MESSAGE);
    }
}
