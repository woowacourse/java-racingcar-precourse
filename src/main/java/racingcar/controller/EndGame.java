package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

import java.util.ArrayList;

public class EndGame {
    private static final String JOIN_DELIMITER = ", ";

    /**
     * 게임 최종 우승자를 계산하여 발표합니다.
     * @param gameSet 이때까지 진행한 게임
     */
    public void announceWinner(Cars gameSet) {
        ArrayList<String> winnerList = gameSet.getWinners();
        showWinners(winnerList);
    }

    private void showWinners(ArrayList<String> winnerList) {
        String winners = String.join(JOIN_DELIMITER, winnerList);
        OutputViewer.showFinalWinner(winners);
    }
}
