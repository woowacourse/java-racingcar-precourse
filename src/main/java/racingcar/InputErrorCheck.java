package racingcar;

import javafx.beans.binding.Bindings;

import java.util.Arrays;

public class InputErrorCheck {
    private static final String LIST_LENGTH_ERROR = " 두 대 이상의 자동차 이름을 입력하세요.";
    private static final String NAME_LENGTH_ERROR = " 자동차 이름은 5글자 이하로 입력하세요.";
    private static final String NAME_NULL_ERROR = " 자동차 이름은 공백이 불가합니다.";
    private static final String DUPLICATED_NAME_ERROR = " 중복된 이름입니다.";
    private static final String ATTEMPT_ZERO_ERROR = " 시도 횟수는 1 이상으로 입력하세요.";
    private static final String ATTEMPT_NUMBER_ERROR = " 시도 횟수는 숫자로 입력하세요.";
    private static final String ERROR = "[ERROR]";

    private static final int MIN_CAR_LIST = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NULL = "";
    private static final String SPACE = " ";
    private static final String SEPARATOR = ",";
    private static String carName;

    public static boolean isValidCar(String userInput) {
        String[] carList = userInput.split(SEPARATOR);
        return isValidListLength(carList) && isValidNameLength(carList) && hasNotContainSpace(carList) && checkDuplicate(carList);
    }

    public static boolean isValidNumber(String userInput) {
        try {
            int parseNum = Integer.parseInt(userInput);
            if (parseNum <= 0) {
                OutputView.printError(ATTEMPT_ZERO_ERROR);
                throw new IllegalArgumentException(ERROR + ATTEMPT_ZERO_ERROR);
            }
        } catch (NumberFormatException e) {
            OutputView.printError(ATTEMPT_NUMBER_ERROR);
            throw new IllegalArgumentException(ERROR + ATTEMPT_NUMBER_ERROR);
        }
        return true;
    }

    private static boolean checkDuplicate(String[] carList) {
        if (Arrays.stream(carList).distinct().count() != carList.length) {
            OutputView.printError(DUPLICATED_NAME_ERROR);
            throw new IllegalArgumentException(ERROR + DUPLICATED_NAME_ERROR);
        }
        return true;
    }

    private static boolean isValidListLength(String[] carList) {
        if (carList.length <= MIN_CAR_LIST) {
            OutputView.printError(LIST_LENGTH_ERROR);
            throw new IllegalArgumentException(ERROR + LIST_LENGTH_ERROR);
        }
        return true;
    }

    private static boolean hasNotContainSpace(String[] carList) {
        for (String carName : carList) {
            if (carName.equals(NULL) || carName.contains(SPACE)) {
                OutputView.printError(NAME_NULL_ERROR);
                throw new IllegalArgumentException(ERROR + NAME_NULL_ERROR);
            }
        }
        return true;
    }

    private static boolean isValidNameLength(String[] carList) {
        for (String carName : carList) {
            try {
                if (carName.length() > MAX_NAME_LENGTH || carName.length() == 0) {
                    OutputView.printError(NAME_LENGTH_ERROR);
                    throw new IllegalArgumentException(ERROR + NAME_LENGTH_ERROR);
                }
            } catch (IllegalArgumentException exception) {
                return false;
            }
        }
        return true;
    }
}