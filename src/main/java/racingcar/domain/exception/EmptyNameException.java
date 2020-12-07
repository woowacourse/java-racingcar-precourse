package racingcar.domain.exception;

public class EmptyNameException extends RuntimeException {
    private static final String EMPTY_NAME_ERROR_MESSAGE = "[ERROR] 공백은 이름이 될 수 없습니다.";

    public EmptyNameException() {
        super(EMPTY_NAME_ERROR_MESSAGE);
    }
}