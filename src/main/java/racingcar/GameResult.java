package racingcar;

import static racingcar.Messages.FINAL_WINNER_IS;

import java.util.List;

public class GameResult {

    private final Winners winners;

    public GameResult(Winners winners) {
        this.winners = winners;
    }

    public static GameResult getResult(List<Car> cars) {
        return new GameResult(Winners.getWinners(cars));
    }

    public void printWinners() {
        System.out.println(FINAL_WINNER_IS + winners.getWinnerNames());
    }
}
