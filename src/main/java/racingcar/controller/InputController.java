package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class InputController {

	public Cars getInput_Car() {
		Cars carList;
		while (true) {
			String[] carName = InputView.getCarNames();
			try {
				carList = new Cars(carName);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return carList;
	}
}