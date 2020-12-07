package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

public class ProcessGame {

    public void playTurns(Cars gameSet, int turnNumber) {
        OutputViewer.initiateResult();
        for (int i = 0; i < turnNumber; i++) {
            gameSet.oneTurn();
            showTurnResult(gameSet);
        }
    }

    private void showTurnResult(Cars gameSet) {
        gameSet.getCarList().forEach(OutputViewer::participantScoreName);
        OutputViewer.spaceBetweenGames();
    }
}
