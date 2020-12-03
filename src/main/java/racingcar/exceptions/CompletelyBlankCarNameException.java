package racingcar.exceptions;

public class CompletelyBlankCarNameException extends IllegalArgumentException {
    private static final String message = "[ERROR] 자동차 이름으로 개행문자를 입력하셨습니다. 다시 입력해주세요.";

    public CompletelyBlankCarNameException() {
        super(message);
    }
}
