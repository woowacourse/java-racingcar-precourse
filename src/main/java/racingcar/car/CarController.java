package racingcar.car;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class CarController {
	private CarFactory carFactory;

	public CarController() {
		carFactory = new CarFactory();
	}

	public CarCarrier createCars() {
		InputView.showCarNamesMessage();
		requestCarNames();
		return carFactory.generateCars();
	}

	private void requestCarNames() {
		try {
			carFactory.inputNames(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			requestCarNames();
		}
	}
}
