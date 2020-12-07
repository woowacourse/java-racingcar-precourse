package racingcar;

import static racingcar.Messages.FINAL_WINNER_IS;
import static utils.PrintUtils.print;

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
        print(FINAL_WINNER_IS + winners.getNames());
    }
}
