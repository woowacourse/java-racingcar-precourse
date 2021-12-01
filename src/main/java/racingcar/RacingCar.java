package racingcar;

import racingcar.exceptions.CarListException;
import racingcar.view.View;
import racingcar.view.CarListView;

public class RacingCar {
	View view;

	public void racingCar() {
		view = new CarListView();

		printCarList();
	}

	private void printCarList() {
		view.printView();

		getUserCarList();
	}

	private void getUserCarList() {
		try {
			String userCarList = view.getUserInput();
			CarListException.carListException(userCarList);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			printCarList();
		}
	}

}
