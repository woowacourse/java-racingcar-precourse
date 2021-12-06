package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;


import racingcar.domain.Car;
import racingcar.domain.GameManager;

public class RacingGame {
	GameManager gameManager = new GameManager();

	public void run() {
		printCarNameInputMessage();
		Car[] carName = gameManager.createCarInstance(inputCarName());

		printAttemptInputMessage();
		int attemptNumber = inputAttemptNumber();

		printExecutionResult();
		for (int i = 0; i < attemptNumber; i++) {
			gameManager.makeCarMove(carName);
			printCarMovementStatus(carName);
			System.out.println();
		}

		printRacingWinner(gameManager.getWinner(carName));
	}

}
