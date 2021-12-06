package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
	InputView inputView;

	public GameController() {
		this.inputView = new InputView();
	}

	public void run() {
		inputView.getCarNames();
		generateCars();
	}

	public void generateCars() {
	}
}
