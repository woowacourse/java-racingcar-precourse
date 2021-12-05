package racingcar.exception;

public class RacingGameCannotRaceRoundException extends RuntimeException {

    private static final String RACING_GAME_RACE_ZERO_ROUND_ERROR_MESSAGE = "[ERROR] 시도횟수가 남지 않았을 때는 race 할 수 없습니다.";

    public RacingGameCannotRaceRoundException() {
        super(RACING_GAME_RACE_ZERO_ROUND_ERROR_MESSAGE);
    }
}
