package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

public class Application {

    public static void main(String[] args) {
        // TODO 구현 진행
        RacingController racingGameController = new RacingController(
                new InputDisplay(),
                new OutputDisplay()
        );

        racingGameController.playRacingGame();
    }
}
