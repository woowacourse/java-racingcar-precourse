package racingcar.game;

import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class GameController {
	public void run() {
		Game game = new Game();
		CarNames carNames = new CarNames();
		InputView.startMessage();
		inputCarName(carNames);
		Cars cars = new Cars(carNames.generateCar());
		Attempts attempts = new Attempts();
		inputAttempts(attempts);
	}

	private void inputCarName(CarNames carNames) {
		try {
			carNames.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputCarName(carNames);
		}
	}

	private void inputAttempts(Attempts attempts) {
		try {
			attempts.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputAttempts(attempts);
		}
	}
}
