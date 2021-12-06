package racingcar.gameresult;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RacingResults> racingGameResult;

    public RacingGameResult(int numberOfRounds) {
        this.racingGameResult = new ArrayList<>(numberOfRounds);
    }

    public void add(RacingResults racingResults) {
        racingGameResult.add(racingResults);
    }

    public List<RacingResults> getRacingGameResult() {
        return racingGameResult;
    }
}
