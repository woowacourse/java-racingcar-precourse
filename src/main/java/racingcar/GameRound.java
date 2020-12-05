package racingcar;

public class GameRound {
    private int gameRound;

    GameRound(String round) {
        if (!round.matches("\\d{1,}")) {
            throw new IllegalGameRoundException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (round.equals("0")) {
            throw new IllegalGameRoundException("[ERROR] 시도 횟수는 0보다 커야 한다.");
        }
        this.gameRound = Integer.parseInt(round);
    }
}
