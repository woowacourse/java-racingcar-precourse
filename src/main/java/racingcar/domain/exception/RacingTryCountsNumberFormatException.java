package racingcar.domain.exception;

public class RacingTryCountsNumberFormatException extends RuntimeException {
    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상의 숫자만 가능합니다.";

    public RacingTryCountsNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
