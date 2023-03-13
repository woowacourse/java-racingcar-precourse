package racingcar.Exceptions;

public class CarNameLengthException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_CARS_NAME_LENGTH = "[ERROR] 자동차 이름 길이는 5자 이내여야 합니다. ";

    public CarNameLengthException() {
        super(EXCEPTION_MESSAGE_CARS_NAME_LENGTH);
    }
}
