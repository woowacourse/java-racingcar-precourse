package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Player;
import racingcar.domain.Racing;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		RacingController racingController = new RacingController(new Player(), new Racing());
		racingController.startRacing();
    }
}
