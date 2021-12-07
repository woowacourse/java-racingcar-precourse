package racingcar.view;

import racingcar.gameresult.RoundResult;

public class RoundResultView {
    private final RoundResult roundResult;

    public RoundResultView(RoundResult roundResult) {
        this.roundResult = roundResult;
    }

    public void print() {
        printResults();
        printNewLine();
    }

    private void printResults() {
        roundResult.getRacingResults().stream()
                .map(RacingResultView::new)
                .forEach(RacingResultView::print);
    }

    private void printNewLine() {
        System.out.println();
    }
}
