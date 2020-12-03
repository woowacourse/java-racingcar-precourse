package racingcar;

public class GameResult {

    private final Winners winners;

    public GameResult(Winners winners) {
        this.winners = winners;
    }

    public void printWinners() {
        System.out.println(winners.getWinnerNames());
    }
}
