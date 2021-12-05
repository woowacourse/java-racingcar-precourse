package racingcar.exception;

public class RacingGameRoundIntegerException extends IllegalArgumentException {

    private static final String RACING_GAME_ROUND_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public RacingGameRoundIntegerException() {
        super(RACING_GAME_ROUND_INTEGER_ERROR_MESSAGE);
    }
}
