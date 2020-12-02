package racingcar.domain.race.exception;

public class CarNameLongerThanMaximumException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다. (입력 값: '%s')";

    public static final int MAXIMUM_SIZE_OF_CAR_NAME = 5;

    public CarNameLongerThanMaximumException(final String input) {
        super(String.format(MESSAGE, input));
    }
}
