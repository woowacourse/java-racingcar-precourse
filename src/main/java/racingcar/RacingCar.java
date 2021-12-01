package racingcar;

import racingcar.view.InputView;
import racingcar.view.StartView;

public class RacingCar {
	InputView view;

	public void racingCar() {
		getUserCarList();
	}

	private void getUserCarList() {
		view = new StartView();
		String userCarList = view.getUserInput();
	}
}
