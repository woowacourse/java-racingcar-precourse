import domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private List<Car> cars;
    private final int trials;

    public RacingGame(List<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    private void hello() {

    }

    public void play(RacingTrial racingTrial, ScoreBoard board) {
        // trials 만큼 시도하는지
        IntStream.range(0, trials).forEach((t) -> {
            racingTrial.doTrial(this.cars, board);
        });

        board.PrintWinners(this.cars);
    }
}
