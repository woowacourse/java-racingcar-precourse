package racingcar.exception;

public class RacingGameZeroRoundException extends IllegalArgumentException {

    private static final String RACING_GAME_ZERO_ROUND_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    public RacingGameZeroRoundException() {
        super(RACING_GAME_ZERO_ROUND_ERROR_MESSAGE);
    }
}
