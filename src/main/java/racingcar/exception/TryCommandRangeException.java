package racingcar.exception;

public class TryCommandRangeException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_TRY_COMMAND_RANGE = "[ERROR] 시도횟수는 최소 %d, 최대 %d 입니다.";

    public TryCommandRangeException(int minTry, int maxTry) {
        super(String.format(EXCEPTION_MESSAGE_TRY_COMMAND_RANGE, minTry, maxTry));
    }
}
