package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
	InputView inputView;

	public GameController() {
		this.inputView = new InputView();
	}

	public void init() {
		String inputCarNames = inputView.getCarNames();
	}
}
