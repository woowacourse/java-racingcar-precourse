package racingcar.validation;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]+$";

    private static final String DIGIT_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String TRIAL_ERROR_MESSAGE = "시도 횟수 1이상의 숫자여야 한다.";
    private static final String NAME_ERROR_MESSAGE = "자동차 이름은 구분자와 알파벳만 가능합니다";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름의 길이는 1이상 5이하입니다.";

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
}
