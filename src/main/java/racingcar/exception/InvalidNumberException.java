package racingcar.exception;

public class InvalidNumberException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 1이상의 숫자를 입력해주세요. %s는 유효하지 않습니다.";

    public InvalidNumberException(String input) {

        super(String.format(ERROR_MESSAGE, input));
    }
}
