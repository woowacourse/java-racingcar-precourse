package racingcar.domains.validate;

import racingcar.ErrorMessageGenerator;
import racingcar.domains.error.RacingCarGameException;

public class AttemptNumberInputValidator implements Validator<String> {
    private static final String NOT_A_NUMBER_MESSAGE =
            ErrorMessageGenerator.generateErrorMessage("입력이 숫자가 아닙니다.");
    private static final String NOT_A_POSITIVE_NUMBER_MESSAGE =
            ErrorMessageGenerator.generateErrorMessage("입력이 0보다 작거나 같습니다.");

    private String attemptNumber;

    @Override
    public void isValid(String attemptNumber) throws RacingCarGameException {
        this.attemptNumber = attemptNumber;

        isNumeric();
        isPositiveNumber();
    }

    private void isNumeric() throws RacingCarGameException {
        try {
            Integer.parseInt(attemptNumber);
        } catch (NumberFormatException e) {
            throw new RacingCarGameException(NOT_A_NUMBER_MESSAGE);
        }
    }

    private void isPositiveNumber() throws RacingCarGameException {
        if (Integer.parseInt(attemptNumber) <= 0) {
            throw new RacingCarGameException(NOT_A_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
