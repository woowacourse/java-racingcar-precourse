package racingcar.exception;

public class CarNameBlankException extends IllegalArgumentException {

    private static final String CAR_BLANK_CONTAIN_NAME_ERROR_MESSAGE = "[ERROR] Car의 이름은 공백이 포함될 수 없습니다.";

    public CarNameBlankException() {
        super(CAR_BLANK_CONTAIN_NAME_ERROR_MESSAGE);
    }
}
