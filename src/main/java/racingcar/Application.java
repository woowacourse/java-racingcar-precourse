package racingcar;

import racingcar.controller.GameController;

public class Application {
	public static void main(String[] args) {
		GameController game = new GameController();
		game.setRacingCars();
		game.setRoundNum();
		game.play();
		game.showWinner();
	}
}
