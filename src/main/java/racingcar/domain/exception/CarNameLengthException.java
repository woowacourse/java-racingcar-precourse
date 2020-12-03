package racingcar.domain.exception;

public class CarNameLengthException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 자동차 이름의 길이는 1자 이상 5자 이하여야 합니다.";

    public CarNameLengthException() {
        super(ERROR_MESSAGE);
    }
}
