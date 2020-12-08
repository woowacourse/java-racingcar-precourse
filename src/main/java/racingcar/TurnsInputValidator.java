package racingcar;

import static racingcar.Messages.TURNS_SHOULD_BE_GREATER_THAN_ONE;
import static racingcar.Messages.TURNS_SHOULD_BE_INTEGER;
import static utils.PrintUtils.print;

import exceptions.InvalidInputException;

public class TurnsInputValidator {

    private boolean valid;
    private Integer turns;

    public TurnsInputValidator() {
        valid = false;
        turns = null;
    }

    public int getTurns() {
        return turns;
    }

    public boolean isValid() {
        return valid;
    }

    public void validate(String input) {
        try {
            validateIsInteger(input);
            validateIsMoreThanOne();

            validationSuccess();
        } catch (InvalidInputException e) {
            print(e.getMessage());
        }
    }

    private void validateIsInteger(String input) {
        try {
            turns = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(TURNS_SHOULD_BE_INTEGER);
        }
    }

    private void validateIsMoreThanOne() {
        if (turns < 1) {
            throw new InvalidInputException(TURNS_SHOULD_BE_GREATER_THAN_ONE);
        }
    }

    private void validationSuccess() {
        valid = true;
    }
}
