package racingcar.util.validator;

import racingcar.util.ErrorMessage;
import racingcar.util.InputCondition;

public class NumberOfRaceValidator implements InputValidator {
    @Override
    public void validate(String input) {
        validateNumber(input);
        validateNumberRange(convertToInteger(input));
    }

    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!input.matches(InputCondition.NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < InputCondition.NUMBER_MIN_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
