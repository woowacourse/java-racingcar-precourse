package racingcar.car;

import racingcar.game.RacingGame;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class CarController {
	private CarFactory carFactory;

	public CarController() {
		carFactory = new CarFactory();
	}

	public RacingGame createCars() {
		InputView.showCarNamesMessage();
		requestCarNames();
		return new RacingGame(carFactory.generateCars());
	}

	private void requestCarNames() {
		try {
			carFactory.inputNames();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			requestCarNames();
		}
	}
}
