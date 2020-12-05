package racingcar.domain.exception;

public class ValidationException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public ValidationException(final String message) {
        super(ERROR_MESSAGE + message);
    }
}
