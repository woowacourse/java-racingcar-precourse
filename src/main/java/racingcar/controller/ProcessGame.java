package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputViewer;

public class ProcessGame {
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
