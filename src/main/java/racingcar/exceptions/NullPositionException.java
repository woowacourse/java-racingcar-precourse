package racingcar.exceptions;

public class NullPositionException extends RuntimeException {
    private static final String message = "[ERROR] 자동차의 position 값에 null 값이 담겨있습니다. ";

    public NullPositionException() {
        super(message);
    }
}
