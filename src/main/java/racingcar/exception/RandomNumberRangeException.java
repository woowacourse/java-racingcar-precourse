package racingcar.exception;

public class RandomNumberRangeException extends IllegalArgumentException {

    private static final String RANDOM_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 랜덤 값은 1~9사이의 값만 들어와야 합니다.";

    public RandomNumberRangeException() {
        super(RANDOM_NUMBER_RANGE_ERROR_MESSAGE);
    }
}
