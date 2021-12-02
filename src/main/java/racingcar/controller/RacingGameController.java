package racingcar.controller;

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
		OutputView.printExcutionResultMessage();
		playGame();
		printWinner();
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

	private void printWinner() {
		OutputView.printWinner(racingCars.getWinner());
	}
}
