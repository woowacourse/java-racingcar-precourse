package racingcar;

import java.util.List;

public class Validator {

    public static final String ERROR_MESSAGE_CAR_NAME = "[ERROR] 각 자동차 이름은 길이 5 이하의 영어 대,소문자 및 숫자(0~9)로 구성되어야 합니다.";
    public static final String REGULAR_EXPRESSION = "^[a-zA-Z0-9]{1,5}$";
    public static final String ERROR_MESSAGE_CAR_COUNT = "[ERROR] 자동차는 2대 이상 입력되어야 합니다.";

    public void validateRuleOfCarNamesLength(List<Car> splitCarNames) {
        for (Car splitCarName : splitCarNames) {
            if (!checkCarNames(splitCarName)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME);
            }
        }
    }

    private boolean checkCarNames(Car splitCarName) {
        return splitCarName.getCarName().matches(REGULAR_EXPRESSION);
    }

    public void validateRuleOfCarCount(List<Car> splitCarNames) {
        if (!checkCarCount(splitCarNames)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_COUNT);
        }
    }

    private boolean checkCarCount(List<Car> splitCarNames) {
        return splitCarNames.size() > 1;
    }

}
