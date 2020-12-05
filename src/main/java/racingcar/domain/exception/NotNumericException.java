package racingcar.domain.exception;

public class NotNumericException extends ValidationException {

    public static final String NOT_NUMERIC_MESSAGE = "시도 횟수는 숫자여야 합니다. 입력한 값은 %s 입니다";

    public NotNumericException(String round) {
        super(String.format(NOT_NUMERIC_MESSAGE, round));
    }
}
