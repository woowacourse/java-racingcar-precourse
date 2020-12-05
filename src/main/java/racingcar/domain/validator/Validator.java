package racingcar.domain.validator;

import racingcar.domain.exception.ValidationException;

public abstract class Validator {

    public static final String INPUT_EMPTY_MESSAGE = "null 값 혹은 빈 문자열을 입력하셨습니다.";

    public void validate(final String input) {
        checkNullOrEmpty(input);
    }

    public void checkNullOrEmpty(final String input) {
        if (input == null || input.isEmpty()) {
            throw new ValidationException(INPUT_EMPTY_MESSAGE);
        }
    }
}
