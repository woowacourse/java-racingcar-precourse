package racingcar.view;

import static racingcar.utils.StringUtils.GAME_RESULT_NOTICE_PHRASE;

import racingcar.gameresult.GameResult;

public class GameResultView {
    private final GameResult gameResult;

    public GameResultView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void print() {
        printNoticePhrase();
        gameResult.getRoundResults().stream()
                .map(RoundResultView::new)
                .forEach(RoundResultView::print);
    }

    private void printNoticePhrase() {
        System.out.println();
        System.out.println(GAME_RESULT_NOTICE_PHRASE);
    }
}
