package racingcar.domain;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public CustomIllegalArgumentException(String message) {
        super(ERROR_MESSAGE + message);
    }
}
