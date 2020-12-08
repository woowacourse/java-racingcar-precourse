package racingcar;

import racingcar.controller.EndGame;
import racingcar.controller.Initiator;
import racingcar.controller.ProcessGame;
import racingcar.domain.Cars;
import racingcar.domain.Turns;

import java.util.Scanner;

public class RacingGame {
    private Initiator initiator;
    private ProcessGame processGame;
    private EndGame endGame;

    RacingGame(Scanner scanner) {
        this.initiator = new Initiator(scanner);
        this.processGame = new ProcessGame();
        this.endGame = new EndGame();
    }

    /* 전체적인 게임 세팅 및 플레이를 하는 메서드 */
    public void play() {
        Cars gameSet = initiator.initiateParticipants();
        Turns gameTurns = initiator.initiateTurns();
        processGame.playTurns(gameSet, gameTurns);
        endGame.announceWinner(gameSet);
    }
}
