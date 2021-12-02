package racingcar.controller;

import racingcar.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void start() {
		makeCars();
		makeRoundNumber();
	}

	private void makeCars() {
		String carNames = getCarNamesInput();
	}

	private String getCarNamesInput() {
		OutputView.printCarNameRequestMessage();
		String carNames = InputView.getCarName();
		try {
			InputValidator.checkIsValidCarNames(carNames);
		} catch (Exception exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getCarNamesInput();
		}
		return carNames;
	}

	private void makeRoundNumber() {
		String roundNumber = getRoundNumberInput();
	}

	private String getRoundNumberInput() {
		OutputView.printRoundNumberRequestMessage();
		String roundNumber = InputView.getRoundNumber();

		return roundNumber;
	}
}
