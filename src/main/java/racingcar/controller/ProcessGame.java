package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

public class ProcessGame {
    private static final int START_TURN = 0;

    /**
     * 정해진 횟수만큼 게임을 진행한다.
     * @param gameSet 진행할 게임 세트
     * @param turnNumber 게임을 진행할 횟수
     */
    public void playTurns(Cars gameSet, int turnNumber) {
        OutputViewer.initiateResult();
        for (int i = START_TURN; i < turnNumber; i++) {
            gameSet.processOneTurn();
            showTurnResult(gameSet);
        }
    }

    private void showTurnResult(Cars gameSet) {
        gameSet.getCarList()                             //gameSet으로부터 CarList 받기
               .forEach(OutputViewer::showScoreName);    //각각의 진행단계 출력하기
        OutputViewer.insertSpaceBetweenGames();
    }
}