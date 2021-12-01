package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.start();
    }
}
