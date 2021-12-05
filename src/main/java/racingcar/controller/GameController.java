package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

public class GameController {

	private static final int MINIMUM_ATTEMPT_NUMBER = 0;

	private GameController() {
	}

	public static void playRacing(Cars cars, int numberOfAttempts) {
		OutputView.printExecutionResult();
		for (int i = MINIMUM_ATTEMPT_NUMBER; i < numberOfAttempts; i++) {
			cars.showCarsPosition();
		}
		getFinalWinner(cars);
	}

	private static void getFinalWinner(Cars cars) {
		int firstPosition;

		firstPosition = cars.getFirstPosition();
		OutputView.printWinner(cars.getWinner(firstPosition));
	}
}
