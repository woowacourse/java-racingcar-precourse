package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.utils.CarUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	private static final int MINIMUM_ATTEMPT_NUMBER = 0;

	public static void playGame() {
		List<String> carNames = InputView.writeCarNames();
		Cars cars = CarUtils.makeCars(carNames);
		int numberOfAttempts = InputView.writeNumberOfAttempts();
		racing(cars, numberOfAttempts);
	}

	public static void racing(Cars cars, int numberOfAttempts) {
		OutputView.printExecutionResult();
		for (int i = MINIMUM_ATTEMPT_NUMBER; i < numberOfAttempts; i++) {
			cars.showCarsPosition();
		}
		getFinalWinner(cars);
	}

	public static void getFinalWinner(Cars cars) {
		int firstPosition = cars.getFirstPosition();
		OutputView.printWinner(cars.getWinner(firstPosition));
	}
}
