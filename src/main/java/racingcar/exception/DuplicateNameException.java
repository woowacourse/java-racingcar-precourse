package racingcar.exception;

public class DuplicateNameException extends RuntimeException {

    private static final String ERROR_MESSAGE = "중복된 이름이 있습니다.";

    public DuplicateNameException() {
        super(ERROR_MESSAGE);
    }

}
