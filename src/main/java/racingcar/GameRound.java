package racingcar;

public class GameRound {
    private int gameRound;

    public GameRound(String round) {
        this.gameRound = Integer.parseInt(round);
    }

    public boolean isGameOver(int thisRound) {
        if (gameRound < thisRound) {
            return true;
        }
        return false;
    }
}
