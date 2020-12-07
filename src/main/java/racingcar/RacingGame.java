package racingcar;

import racingcar.controller.EndGame;
import racingcar.controller.Initiator;
import racingcar.controller.ProcessGame;
import racingcar.domain.Cars;

import java.util.Scanner;

public class RacingGame {
    private final Initiator initiator;
    private final ProcessGame processGame;
    private final EndGame endGame;

    RacingGame(Scanner scanner) {
        this.initiator = new Initiator(scanner);
        this.processGame = new ProcessGame();
        this.endGame = new EndGame();
    }

    /* 전체적인 게임 세팅 및 플레이를 하는 메서드 */
    public void play() {
        Cars gameSet = initiator.setParticipants();
        int turnNumber = initiator.setTurns();
        processGame.playTurns(gameSet, turnNumber);
        endGame.announceWinner(gameSet);
    }
}
