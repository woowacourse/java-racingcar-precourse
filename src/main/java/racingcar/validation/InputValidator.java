package racingcar.validation;

import java.util.List;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]+$";

    private static final String DIGIT_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String TRIAL_ERROR_MESSAGE = "시도 횟수 1이상의 숫자여야 한다.";
    private static final String NAME_ERROR_MESSAGE = "자동차 이름은 구분자와 알파벳만 가능합니다";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름의 길이는 1이상 5이하입니다.";

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    public static void checkTrial(String trial) {
        if (isNotNumber(trial)) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }

        if (isWrongRange(trial)) {
            throw new IllegalArgumentException(TRIAL_ERROR_MESSAGE);
        }
    }

    private static boolean isNotNumber(String number) {
        return !number.matches(DIGIT_REGEX);
    }

    private static boolean isWrongRange(String number) {
        return Integer.valueOf(number) < 1;
    }
}
