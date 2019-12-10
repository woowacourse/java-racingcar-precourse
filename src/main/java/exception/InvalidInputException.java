package exception;

import domain.Car;

public class InvalidInputException extends IllegalArgumentException {

    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 숫자만 입력할 수 있습니다.";
    public static final String NAME_OVER_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 " + Car.CAR_NAME_LENGTH_LIMIT + "을 넘을 수 없습니다.";
    public static final String NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";
    public static final String NAMES_SIZE_EXCEPTION_MESSAGE = "자동차 경주는 최소 2대의 차 이름이 필요합니다.";
    public static final String NAME_EMPTY_EXCEPTION_MESSAGE = "자동차 이름은 비어있을 수 없습니다.";
    public static final String INVALID_TRIAL_TIME_EXCEPTION_MESSAGE = "시도 횟수는 1이상 입력해야합니다.";

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
