package racingcar.exception;

public class TryCommandNumberException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_TRY_COMMAND_NUMBER = "[ERROR] 시도 횟수는 숫자를 입력해야 합니다.";

    public TryCommandNumberException() {
        super(EXCEPTION_MESSAGE_TRY_COMMAND_NUMBER);
    }
}
