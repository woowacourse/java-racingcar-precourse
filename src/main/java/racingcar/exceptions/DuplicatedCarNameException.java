package racingcar.exceptions;

public class DuplicatedCarNameException extends IllegalArgumentException {
    private static final String message = "[ERROR] 중복된 이름이 존재합니다. 다시 입력해 주세요. ";

    public DuplicatedCarNameException() {
        super(message);
    }
}
