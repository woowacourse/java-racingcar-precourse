package racingcar;

import racingcar.game.RacingGame;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		RacingGame racingGame = new RacingGame();
		racingGame.init();
		racingGame.gameStart();
		racingGame.awards();
	}
}
