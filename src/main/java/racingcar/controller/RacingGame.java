package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;


import racingcar.domain.Car;
import racingcar.domain.GameManager;

public class RacingGame {
	GameManager gameManager = new GameManager();

	public void run() {
		printCarNameInputMessage();
		Car[] carNameList = gameManager.createCars(inputCarName());

		printAttemptInputMessage();
		int attemptNumber = inputAttemptNumber();

		printExecutionResult();
		for (int i = 0; i < attemptNumber; i++) {
			gameManager.makeCarMoveForward(carNameList);
			printCarMovementStatus(carNameList);
			System.out.println();
		}
		printRacingWinner(gameManager.getWinnerList(carNameList));
	}

}
