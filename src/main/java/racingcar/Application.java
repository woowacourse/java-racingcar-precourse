package racingcar;

import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
        RacingGame racingGame = new RacingGame(
                new InputDisplay(),
                new OutputDisplay()
        );

        racingGame.startRacingGame();
    }
}
