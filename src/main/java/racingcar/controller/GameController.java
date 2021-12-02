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
		cars.showCars();
		System.out.println(InputView.writeNumberOfAttempts());
	}
}
