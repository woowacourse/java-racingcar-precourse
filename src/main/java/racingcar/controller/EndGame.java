package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

import java.util.ArrayList;

public class EndGame {
    /**
     * 게임 최종 우승자를 계산하여 발표합니다.
     * @param gameSet 이때까지 진행한 게임
     */
    public static void announceWinner(Cars gameSet) {
        ArrayList<String> winnerList = gameSet.getWinners();
        showWinners(winnerList);
    }

    private static void showWinners(ArrayList<String> winnerList) {
        String winners = String.join(", ",winnerList);
        OutputViewer.finalWinner(winners);
    }
}
