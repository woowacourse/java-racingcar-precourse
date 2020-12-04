package racingcar.domain.exception;

public class RandomMovingNumberRangeException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 랜덤 이동을 결정하는 랜덤값은 0 이상 9 이하여야 합니다. (값 : %d)";

    public RandomMovingNumberRangeException(int randomNumber) {
        super(String.format(ERROR_MESSAGE, randomNumber));
    }
}
