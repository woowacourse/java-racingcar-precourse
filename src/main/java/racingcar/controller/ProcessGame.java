package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Turns;
import racingcar.view.OutputViewer;

public class ProcessGame {
    /**
     * 정해진 횟수만큼 게임을 진행한다.
     * @param gameSet 진행할 게임 세트
     * @param turns 게임을 진행할 턴
     */
    public void playTurns(Cars gameSet, Turns turns) {
        OutputViewer.initiateResult();
        while (!turns.isEndTurns()) {
            gameSet.processOneTurn();
            turns.processTurn();
            showTurnResult(gameSet);
        }
    }

    private void showTurnResult(Cars gameSet) {
        gameSet.getCarList()                             //gameSet으로부터 CarList 받기
               .forEach(OutputViewer::showScoreName);    //각각의 진행단계 출력하기
        OutputViewer.insertSpaceBetweenGames();
    }
}