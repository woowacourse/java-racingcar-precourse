package racingcar;

import racingcar.controller.GameController;

public class GameClient {

	private GameController gameController;

	public GameClient() {
		this.gameController = new GameController();
	}

	public void play() {
		gameController.inputCars();
		gameController.inputRepeatNumber();
		gameController.getResult();
		gameController.getWinner();
	}
}
