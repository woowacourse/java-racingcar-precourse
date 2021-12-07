package racingcar.config;

import racingcar.controller.GameController;
import racingcar.controller.SprintGameController;

public class ControllerConfig {
	public static GameController getGameController() {
		return new SprintGameController(
			ServiceConfig.getGameService()
		);
	}
}
