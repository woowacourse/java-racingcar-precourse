package racingcar.view;

import java.util.List;

import racingcar.gameresult.RacingResult;
import racingcar.gameresult.RacingResults;

public class RacingResultsView {
    private final RacingResults racingResults;

    public RacingResultsView(RacingResults racingResults) {
        this.racingResults = racingResults;
    }

    public void print() {
        printResults();
        printNewLine();
    }

    private void printResults() {
        List<RacingResult> racingResults = this.racingResults.getRacingResults();
        for (RacingResult racingResult : racingResults) {
            new RacingResultView(racingResult).print();
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}
