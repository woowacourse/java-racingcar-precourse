package racingcar.exception;

public class CarNameNullPointException extends IllegalArgumentException {

    private static final String CAR_NULL_NAME_ERROR_MESSAGE = "[ERROR] Car의 이름은 null이 들어올 수 없습니다.";

    public CarNameNullPointException() {
        super(CAR_NULL_NAME_ERROR_MESSAGE);
    }
}
