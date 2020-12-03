package racingcar.domain.exception;

public class CarNameDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 자동차 이름들 중 중복이 존재해서는 안됩니다.";

    public CarNameDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
