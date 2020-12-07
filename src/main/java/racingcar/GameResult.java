package racingcar;

import static racingcar.Messages.FINAL_WINNER_IS;
import static utils.PrintUtils.print;

import java.util.List;

public class GameResult {
    // todo 개선 필요: 하는일이 너무 없지 않나? 게임 로그를 얘가 가지게 할까?

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
