package racingcar;

import java.io.IOException;
import java.util.Arrays;

public class InputError {
    private final String LIST_LENGTH_ERROR = "두 대 이상의 자동차 이름을 입력하세요.";
    private final String NAME_LENGTH_ERROR = "자동차 이름은 5글자 이하로 입력하세요.";
    private final String NAME_NULL_ERROR = "자동차 이름은 공백이 불가합니다.";
    private final String DUPLICATED_NAME_ERROR = "중복된 이름입니다.";
    private final String ATTEMPT_ZERO_ERROR = "시도 횟수는 1 이상으로 입력하세요.";
    private final String ATTEMPT_NUMBER_ERROR = "시도 횟수는 숫자로 입력하세요.";

    private final int MIN_CAR_LIST = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String NULL = "";
    private final String SPACE = " ";
    private final String SEPARATOR = ",";

    public boolean isValidCar(String userInput) {
        String[] carList = userInput.split(SEPARATOR);
        return isValidListLength(carList) && isValidNameLength(carList) && hasNotContainSpace(carList) && checkDuplicate(carList);
    }

    private boolean isValidListLength(String[] carList) {
        if (carList.length <= MIN_CAR_LIST) {
            OutputView.printError(LIST_LENGTH_ERROR);
            return false;
        }
        return true;
    }

    private boolean hasNotContainSpace(String[] carList) {
        for (String carName : carList) {
            if (carName.equals(NULL) || carName.contains(SPACE)) {
                OutputView.printError(NAME_NULL_ERROR);
                return false;
            }
        }
        return true;
    }

    private boolean isValidNameLength(String[] carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                OutputView.printError(NAME_LENGTH_ERROR);
                return false;
            }
        }
        return true;
    }

}
