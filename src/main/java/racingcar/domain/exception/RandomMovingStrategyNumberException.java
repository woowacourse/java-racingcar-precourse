package racingcar.domain.exception;

public class RandomMovingStrategyNumberException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 랜덤값은 0 이상 9 이하여야 합니다. (값 : %d)";

    public RandomMovingStrategyNumberException(int randomNumber) {
        super(String.format(ERROR_MESSAGE, randomNumber));
    }
}
