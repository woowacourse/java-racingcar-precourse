package racingcar.exception;

public class CarNameDuplicateException extends IllegalArgumentException {

    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 Car 이름이 존재할 수 없습니다.";

    public CarNameDuplicateException() {
        super(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
