package racingcar;

import racingcar.controller.RacingCarGameController;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController();
        racingCarGameController.gamePlay();
    }
}
