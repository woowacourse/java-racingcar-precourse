package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

public class ProcessGame {
    /**
     * 정해진 횟수만큼 게임을 진행한다.
     * @param gameSet 진행할 게임 세트
     * @param turnNumber 게임을 진행할 횟수
     */
    public static void playTurns(Cars gameSet, int turnNumber) {
        OutputViewer.initiateResult();
        for (int i = 0; i < turnNumber; i++) {
            gameSet.processOneTurn();
            showTurnResult(gameSet);
        }
    }

    private static void showTurnResult(Cars gameSet) {
        gameSet.getCarList().forEach(OutputViewer::participantScoreName);
        OutputViewer.spaceBetweenGames();
    }
}
