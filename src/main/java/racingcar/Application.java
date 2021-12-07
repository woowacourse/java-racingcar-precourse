package racingcar;

import controller.RacingGame;

public class Application {
	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.start();
		racingGame.end();
	}
}
