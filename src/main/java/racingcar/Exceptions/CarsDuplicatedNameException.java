package racingcar.Exceptions;

public class CarsDuplicatedNameException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다";

    public CarsDuplicatedNameException() {
        super(EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME);
    }
}
