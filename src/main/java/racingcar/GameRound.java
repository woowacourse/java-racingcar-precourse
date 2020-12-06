package racingcar;

public class GameRound {
    private int gameRound;

    GameRound(String round) {
        validateGameRound(round);
        this.gameRound = changeStringToInt(round);
    }

    private void validateGameRound(String round) {
        if (!round.matches("\\d{1,}")) {
            throw new IllegalGameRoundException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (round.equals("0")) {
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
