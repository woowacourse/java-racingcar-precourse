package racingcar.domain.exception;

public class CarNameException extends RuntimeException {
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 자동차 이름들 중 중복이 존재해서는 안됩니다.";
    private static final String INVALID_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름의 길이는 1자 이상 5자 이하여야 합니다.";

    private CarNameException(String errorMessage) {
        super(errorMessage);
    }

    public static CarNameException ofDuplicatedNames() {
        return new CarNameException(DUPLICATION_ERROR_MESSAGE);
    }

    public static CarNameException ofInvalidNameLength() {
        return new CarNameException(INVALID_LENGTH_ERROR_MESSAGE);
    }
}
