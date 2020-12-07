package racingcar.domains.error;

import racingcar.ErrorMessageGenerator;

public class NotAPositiveNumberException extends Exception {
    private static final String NOT_A_POSITIVE_NUMBER_MESSAGE =
            ErrorMessageGenerator.generateErrorMessage("입력이 0보다 작거나 같습니다.");

    public NotAPositiveNumberException() {
        super(NOT_A_POSITIVE_NUMBER_MESSAGE);
    }
}
