package racingcar.controller;

public class RacingCarErrorException extends IllegalArgumentException {

    private static final String EXCEPTION_PREFIX = "[ERROR]";

    public RacingCarErrorException(String message) {
        super(EXCEPTION_PREFIX + message);
    }
}
