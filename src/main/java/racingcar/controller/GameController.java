package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void start() {
		makeCars();
	}

	private void makeCars() {
		String carNames = getCarNamesInput();
	}

	private String getCarNamesInput() {
		OutputView.printCarNameRequestMessage();
		String carNames = InputView.getCarName();
		return carNames;
	}
}
