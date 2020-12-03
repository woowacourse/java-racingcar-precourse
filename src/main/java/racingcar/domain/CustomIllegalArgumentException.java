package racingcar.domain;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public CustomIllegalArgumentException(String s) {
        super(ERROR_MESSAGE + s);
    }
}
