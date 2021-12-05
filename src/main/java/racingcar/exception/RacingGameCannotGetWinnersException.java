package racingcar.exception;

public class RacingGameCannotGetWinnersException extends RuntimeException {

    private static final String RACING_GAME_CANNOT_GET_WINNER_ERROR_MESSAGE = "[ERROR] 종료되지 않은 게임의 우승자는 반환할 수 없습니다.";

    public RacingGameCannotGetWinnersException() {
        super(RACING_GAME_CANNOT_GET_WINNER_ERROR_MESSAGE);
    }
}
