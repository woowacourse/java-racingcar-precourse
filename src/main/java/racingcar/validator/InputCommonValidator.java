package racingcar.validator;

import racingcar.utils.StringUtils;

public class InputCommonValidator {
    private static final String NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 입력 값은 null 또는 empty 일 수 없습니다.";
    
    public static void validate(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
