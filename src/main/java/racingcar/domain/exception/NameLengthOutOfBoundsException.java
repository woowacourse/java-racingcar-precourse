package racingcar.domain.exception;

public class NameLengthOutOfBoundsException extends RuntimeException {
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";

    public NameLengthOutOfBoundsException() {
        super(NAME_LENGTH_ERROR_MESSAGE);
    }
}
