package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_CAR_NAME_LENGTH = "[ERROR] 자동차이름은 5글자 이하입니다";

    public CarNameLengthException() {
        super(EXCEPTION_MESSAGE_CAR_NAME_LENGTH);
    }
}
