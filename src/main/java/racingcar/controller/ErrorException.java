package racingcar.controller;

public class ErrorException extends IllegalArgumentException {

    private static final String EXCEPTION_PREFIX = "[ERROR]";

    public ErrorException(String message) {
        super(EXCEPTION_PREFIX + message);
    }
}
