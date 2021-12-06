package racingcar.view;

import static racingcar.utils.StringUtils.GAME_RESULT_NOTICE_PHRASE;

import racingcar.gameresult.RacingGameResult;
import racingcar.gameresult.RacingResults;

public class RacingGameResultView {
    private final RacingGameResult racingGameResult;

    public RacingGameResultView(RacingGameResult racingGameResult) {
        this.racingGameResult = racingGameResult;
    }

    public void print() {
        printGameResultNoticePhrase();
        for (RacingResults racingResults : racingGameResult.getRacingGameResult()) {
            new RacingResultsView(racingResults).print();
        }
    }

    private void printGameResultNoticePhrase() {
        System.out.println();
        System.out.println(GAME_RESULT_NOTICE_PHRASE);
    }
}
