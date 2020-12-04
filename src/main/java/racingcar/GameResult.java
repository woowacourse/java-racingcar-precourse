package racingcar;

import static racingcar.Messages.FINAL_WINNER_IS;

public class GameResult {

    private final Winners winners;

    public GameResult(Winners winners) {
        this.winners = winners;
    }

    public void printWinners() {
        System.out.println(FINAL_WINNER_IS + winners.getWinnerNames());
    }
}
