package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.utils.CarUtils;
import racingcar.utils.InputUtils;

public class GameController {

	public static void controlGame() {
		startGame();
	}

	public static void startGame() {
		List<String> carNames = InputUtils.requestCarNames();
		Cars cars = CarUtils.makeCars(carNames);
		cars.showCars();
	}
}
