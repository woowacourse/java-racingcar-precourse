package racingcar.gameresult;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class GameResult {
    private final List<RoundResult> roundResults;

    public GameResult(int numberOfRounds) {
        this.roundResults = new ArrayList<>(numberOfRounds);
    }

    public void record(List<Car> carsAfterRound) {
        addRoundResult(new RoundResult(carsAfterRound));
    }

    private void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
