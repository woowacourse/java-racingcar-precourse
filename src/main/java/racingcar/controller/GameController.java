package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.utils.CarUtils;
import racingcar.view.InputView;

public class GameController {

	public static void controlGame() {
		startGame();
	}

	public static void startGame() {
		List<String> carNames = InputView.writeCarNames();
		Cars cars = CarUtils.makeCars(carNames);
		int numberOfAttempts = InputView.writeNumberOfAttempts();
		racing(cars, numberOfAttempts);
	}

	public static void racing(Cars cars, int numberOfAttempts) {
		for (int i = 0; i < numberOfAttempts; i++) {
			cars.showCarsNumber();
		}
	}
}
