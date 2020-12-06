package racingcar.exceptions;

public class PartiallyBlankCarNameException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 자동차 이름으로 공백을 입력하셨습니다. 다시 입력해 주세요. ";

    public PartiallyBlankCarNameException() {
        super(MESSAGE);
    }
}
