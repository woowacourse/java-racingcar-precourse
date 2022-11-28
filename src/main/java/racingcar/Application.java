package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        final RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
