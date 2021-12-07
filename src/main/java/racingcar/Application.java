package racingcar;

import racingcar.config.AppConfig;
import racingcar.game.Game;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		Application app = new Application();

		Game game = AppConfig.getRacingGame();
		app.run(game);
	}

	private void run(Game game) {
		game.play();
	}
}
