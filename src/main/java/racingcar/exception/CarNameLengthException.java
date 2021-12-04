package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {

    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] Car의 이름은 5자 이하만 입력되어야 합니다.";

    public CarNameLengthException() {
        super(CAR_NAME_LENGTH_ERROR_MESSAGE);
    }
}
