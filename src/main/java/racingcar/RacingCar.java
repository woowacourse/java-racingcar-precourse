package racingcar;

import racingcar.view.View;
import racingcar.view.CarListView;

public class RacingCar {
	View view;

	public void racingCar() {
		getUserCarList();
	}



	private void getUserCarList() {
		view = new CarListView();
		String userCarList = view.getUserInput();
	}

	private void printView() {
		view.printView();
	}

}
