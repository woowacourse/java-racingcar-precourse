package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.RacingRandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new RacingRandomNumberGenerator());
        controller.run();
    }
}
