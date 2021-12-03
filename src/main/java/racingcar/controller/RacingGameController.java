package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.RacingCars;
import racingcar.view.OutputView;

public class RacingGameController {
	private final RacingCars racingCars;
	private final AttemptNumber attemptNumber;

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
			printExecutionForEachOrder();
		}
	}

	private void printExecutionForEachOrder() {
		String executionForEachOrderMessage = racingCars.getExecutionForEachOrderMessage();
		OutputView.printExecutionForEachOrderMessage(executionForEachOrderMessage);
	}

	private void printWinner() {
		OutputView.printWinner(racingCars.getWinner());
	}
}
