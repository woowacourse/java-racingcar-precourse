package racingcar.validator;

import racingcar.ErrorConstants;

import java.util.regex.Pattern;

public class InputCarNameValidator {

    private static final String CORRECT_CAR_NAME_REGEX = "^[가-힣\\w]{1,5}+[가-힣\\w,]{1,5}$";

    public void validate(String inputCarName) {
        if (isWrongType(inputCarName)) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_PREFIX + "자동차 이름은 5자 이하이고, 쉼표로 구분된 문자여야합니다.");
        }
    }

    private boolean isWrongType(String inputCarName) {
        return !Pattern.compile(CORRECT_CAR_NAME_REGEX).matcher(inputCarName).matches();
    }
}
