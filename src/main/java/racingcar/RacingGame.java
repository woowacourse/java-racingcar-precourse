package racingcar;

import racingcar.controller.EndGame;
import racingcar.controller.Initiator;
import racingcar.controller.ProcessGame;
import racingcar.domain.Cars;

public class RacingGame {
    /* 전체적인 게임 세팅 및 플레이를 하는 메서드 */
    public void play() {
        Cars gameSet = Initiator.setParticipants();
        int turnNumber = Initiator.setTurns();
        ProcessGame.playTurns(gameSet, turnNumber);
        EndGame.announceWinner(gameSet);
    }
}
