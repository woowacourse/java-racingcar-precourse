package racingcar.Exceptions;

public class TryCommandNumberException extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_TRY_NUM = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public TryCommandNumberException() {
        super(EXCEPTION_MESSAGE_TRY_NUM);
    }

}
