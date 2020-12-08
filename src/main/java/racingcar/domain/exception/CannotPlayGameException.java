package racingcar.domain.exception;

public class CannotPlayGameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수를 초과했기 때문에 게임을 진행할 수 없습니다.";

    public CannotPlayGameException() {
        super(ERROR_MESSAGE);
    }
}
