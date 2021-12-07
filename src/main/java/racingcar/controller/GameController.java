package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {
	public static void startRace() {
		String[] carNames = Input.carName();
		int tryNumber = Input.tryNumber();

		CarList cars = new CarList(carNames);
		Output.raceStartMsg();
		for (int i = 0; i < tryNumber; i++) {
			cars.moveAll();
			Output.movementState(cars);
		}
		Output.winners(cars);
	}
}
