package racingcar.domain.exception;

public class AttemptCountTypeException extends RuntimeException {
    private static final String COUNT_TYPE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 integer 형식으로 입력해주세요.";

    public AttemptCountTypeException() {
        super(COUNT_TYPE_ERROR_MESSAGE);
    }
}