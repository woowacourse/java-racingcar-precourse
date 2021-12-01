package racingcar.controller;

import static racingcar.view.OutputView.*;

import racingcar.domain.AttemptNumber;
import racingcar.domain.RacingCars;
import racingcar.view.OutputView;

public class RacingGameController {
	private RacingCars racingCars;
	private AttemptNumber attemptNumber;

	public RacingGameController() {
		racingCars = new RacingCars();
		attemptNumber = new AttemptNumber();
	}

	public void startGame() {
		printExcutionResulttMessage();
		playGame();
	}

	private void playGame() {
		while (attemptNumber.isAttemptRemained()) {
			racingCars.move();
			printExcutionForEachOrder();
		}
	}

	private void printExcutionForEachOrder() {
		String excutionForEachOrderMessage = racingCars.getExcutionForEachOrderMessage();
		OutputView.printExcutionForEachOrderMessage(excutionForEachOrderMessage);
	}
}
