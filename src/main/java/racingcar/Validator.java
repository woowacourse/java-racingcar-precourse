package racingcar;

import java.util.Arrays;

public class Validator {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int REPEAT_TIME_MINIMUM = 1;
    private static final int ZERO = 0;

    public String[] validateAllCarNames(String[] waitingCarNames) {
        checkAtLeastOneCarNames(waitingCarNames);
        for (int i = 0; i < waitingCarNames.length; i++) {
            waitingCarNames[i] = removeBlank(waitingCarNames[i]);
            String carName = waitingCarNames[i];
            checkCarNameLength(carName);
            checkDuplicatedName(waitingCarNames, carName);
        }
        return waitingCarNames;
    }

    public Integer validateRepeatTimes(String rawRepeatTimes) {
        Integer repeatTimes = convertToNumber(rawRepeatTimes);
        checkRepeatTimesOverOne(repeatTimes);
        return repeatTimes;
    }

    private void checkAtLeastOneCarNames(String[] waitingCarNames) {
        if (waitingCarNames.length == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 한 대 이상의 차가 참가해야 합니다");
        }
    }

    private String removeBlank(String waitingCarName) {
        return waitingCarName.trim();
    }

    private void checkCarNameLength(String carName) {
        checkMaxCarNameLength(carName);
        checkMinCarNameLength(carName);
    }

    private void checkDuplicatedName(String[] waitingCarNames, String carName) {
        boolean isDuplicated = Arrays.asList(waitingCarNames).contains(carName);
        if (isDuplicated) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복은 불가능 합니다");
        }
    }

    private void checkMaxCarNameLength(String carName) {
        if (isCarNameLengthOverFive(carName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 이름의 길이가 5를 넘습니다");
        }
    }

    private boolean isCarNameLengthOverFive(String carName) {
        return carName.length() > CAR_NAME_LENGTH_LIMIT;
    }

    private void checkMinCarNameLength(String carName) {
        if (carName.length() == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 이름은 공백이 불가합니다");
        }
    }

    private Integer convertToNumber(String rawRepeatTimes) {
        try {
            return Integer.parseInt(rawRepeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자를 입력해야 합니다.");
        }
    }

    private void checkRepeatTimesOverOne(Integer repeatTimes) {
        if (repeatTimes < REPEAT_TIME_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1 이상의 수를 입력해야 합니다");
        }
    }
}
