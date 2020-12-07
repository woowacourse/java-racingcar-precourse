package racingcar.domains.error;

import racingcar.ErrorMessageGenerator;

public class NotANumberException extends Exception {
    private static final String NOT_A_NUMBER_MESSAGE =
            ErrorMessageGenerator.generateErrorMessage("입력이 숫자가 아닙니다.");

    public NotANumberException() {
        super(NOT_A_NUMBER_MESSAGE);
    }
}
