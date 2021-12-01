package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String ERROR = "[ERROR] ";
    private static final int TRIAL_NUMBER_MIN_VALUE = 1;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNames(String[] carNames) {
        validateUniqueCarNames(carNames);

        for (String carName : carNames) {
            validateCarNameLength(carName);
            validateCarNameFormat(carName);
        }
    }

    public static void validateTrialNum(String input) {
        int trialNum;

        try {
            trialNum = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR + "시도 횟수는 숫자여야 한다.");
        }

        validateTrialNumRange(trialNum);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERROR + "자동차명은 최소 1글자여야 한다.");
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR + "자동차명은 최대 5글자여야 한다.");
        }
    }

    private static void validateCarNameFormat(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ERROR + "자동차명에 공백이 포함되어서는 안 된다.");
        }
    }

    private static void validateUniqueCarNames(String[] carNames) {
        List<String> carNameList = Arrays.asList(carNames);
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() > carNameSet.size()) {
            throw new IllegalArgumentException(ERROR + "같은 자동차명을 중복 사용해서는 안 된다.");
        }
    }

    private static void validateTrialNumRange(int trialNum) {
        if (trialNum < TRIAL_NUMBER_MIN_VALUE) {
            throw new IllegalArgumentException(ERROR + "시도 횟수는 1회 이상이어야 한다.");
        }
    }
}
