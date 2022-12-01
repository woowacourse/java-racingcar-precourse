package racingcar.validator;

import racingcar.ErrorConstants;

import java.util.regex.Pattern;

public class InputTryNumberValidator {

    private static final String CORRECT_TRY_NUMBER_REGEX = "[1-9]+";

    public void validate(String inputTryNumber) {
        if (isNotDigit(inputTryNumber)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "시도 횟수는 1이상의 숫자여야합니다.");
        }
    }

    private boolean isNotDigit(String inputTryNumber) {
        return !Pattern.compile(CORRECT_TRY_NUMBER_REGEX).matcher(inputTryNumber).matches();
    }
}
