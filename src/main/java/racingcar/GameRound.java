package racingcar;

public class GameRound {
    private static final String GAME_ROUND_NUMBER_REGEX = "\\d{1,}";
    private static final String GAME_ROUND_ZERO = "0";

    private int gameRound;

    GameRound(String round) {
        validateGameRound(round);
        this.gameRound = changeStringToInt(round);
    }

    private void validateGameRound(String round) {
        if (!round.matches(GAME_ROUND_NUMBER_REGEX)) {
            throw new IllegalGameRoundException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (round.equals(GAME_ROUND_ZERO)) {
            throw new IllegalGameRoundException("[ERROR] 시도 횟수는 0보다 커야 한다.");
        }
    }

    private int changeStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public boolean isGameOver(int thisRound) {
        if (gameRound < thisRound) {
            return true;
        }
        return false;
    }
}
