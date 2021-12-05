package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.OutputView;

public class GameController {
	private String[] carNameArray;
	private int attemptNumber;

	private void inputInitialValue() {
		InputController inputController = new InputController();
		carNameArray = inputController.inputCarName();
		attemptNumber = inputController.inputAttemptNumber();
	}

	public void run() {
		inputInitialValue();
		Race race = new Race(carNameArray, attemptNumber);
		race.start();
		OutputView.printWinners(race.findWinner());
	}
}