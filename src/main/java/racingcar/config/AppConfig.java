package racingcar.config;

import racingcar.game.Game;
import racingcar.game.RacingGame;

public class AppConfig {
	public static Game getRacingGame() {
		return new RacingGame(
			ViewConfig.getInputView(),
			ViewConfig.getOutputView(),
			ControllerConfig.getGameController()
		);
	}
}
