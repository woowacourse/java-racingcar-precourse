package racingcar.domain;

public class ValidationException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public ValidationException(String message) {
        super(ERROR_MESSAGE + message);
    }
}
