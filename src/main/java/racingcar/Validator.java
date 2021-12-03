package racingcar;

import java.util.List;

public class Validator {

    private static final String ERROR_MESSAGE_CAR_NAME = "[ERROR] 각 자동차 이름은 길이 5 이하의 영어 대,소문자 및 숫자(0~9)로 구성되어야 합니다.";
    private static final String REGULAR_CAR_NAME_EXPRESSION = "^[a-zA-Z0-9]{1,5}$";
    private static final String REGULAR_TRY_COUNT_EXPRESSION = "^[1-9]{1}$";
    private static final String ERROR_MESSAGE_CAR_COUNT = "[ERROR] 자동차는 2대 이상 입력되어야 합니다.";
    private static final String ERROR_MESSAGE_TRY_COUNT = "[ERROR] 게임 시도 횟수는 1~9 범위의 숫자만 가능합니다.";

    public void validateCar(List<Car> carNames) {
        validateCarNames(carNames);
        validateCarCount(carNames);
    }

    public void validateCarNames(List<Car> splitCarNames) {
        for (Car splitCarName : splitCarNames) {
            if (!checkCarNames(splitCarName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }
    }

    private boolean checkCarNames(Car splitCarName) {
        return splitCarName.getCarName().matches(REGULAR_CAR_NAME_EXPRESSION);
    }

    public void validateCarCount(List<Car> splitCarNames) {
        if (!checkCarCount(splitCarNames)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_COUNT);
        }
    }

    private boolean checkCarCount(List<Car> splitCarNames) {
        return splitCarNames.size() > 1;
    }

    public void validateAttemptCount(final String inputAttemptCount) {
        if (!checkAttemptCount(inputAttemptCount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT);
        }
    }

    private boolean checkAttemptCount(String inputAttemptCount) {
        return inputAttemptCount.matches(REGULAR_TRY_COUNT_EXPRESSION);
    }

}
