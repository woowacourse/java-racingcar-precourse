package racingcar.util.validator;

import racingcar.util.ErrorMessage;
import racingcar.util.InputCondition;
import racingcar.util.Symbol;

import java.util.Arrays;
import java.util.HashSet;

public class CarNameValidator implements InputValidator {
    @Override
    public void validate(String input) {
        validateContainComma(input);
        validateContainCommaLastString(input);
        validateContainSpace(input);

        String[] carNames = splitByComma(input);

        validateLength(carNames);
        validateDuplicateName(carNames);
    }

    public String[] splitByComma(String input) {
        return input.split(Symbol.COMMA);
    }

    private void validateContainComma(String input) {
        if (!input.contains(Symbol.COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NO_RIVAL.getMessage());
        }
    }

    private void validateContainCommaLastString(String input) {
        if (input.endsWith(Symbol.COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_CONTAIN_COMMA_LAST_STRING.getMessage());
        }
    }

    private void validateContainSpace(String input) {
        if (input.contains(Symbol.SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_CONTAIN_SPACE.getMessage());
        }
    }

    private void validateLength(String[] carNames) {
        if (!Arrays.stream(carNames).allMatch(name ->
                name.length() >= InputCondition.NAME_MIN_LENGTH && name.length() <= InputCondition.NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_LENGTH.getMessage());
        }
    }

    private void validateDuplicateName(String[] carNames) {
        if (!Arrays.stream(carNames).allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_DUPLICATE.getMessage());
        }
    }
}
