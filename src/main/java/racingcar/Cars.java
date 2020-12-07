package racingcar;

import java.util.ArrayList;

import java.util.List;

public class Cars {
	ArrayList<Car> carList = new ArrayList<Car>();

	public void arrayOfObjects(String[] carName) {
		for (int i = 0; i < carName.length; i++) {
			Car car = new Car(carName[i]);
			carList.add(i, car);
		}
		moveCarRun(carList);
	}

	private void moveCarRun(ArrayList<Car> carList) {
		InputView inputView = new InputView();
		int count = inputView.inputChooseRacingCount();

		for (int i = 0; i < carList.size(); i++) {
			Car a = carList.get(i);
			a.countMovePosition(count);
		}
		printMoveCars(carList);
	}

	private void printMoveCars(ArrayList<Car> carList) {
		Message.executionResult();
		
		for (int i = 0; i < carList.size(); i++) {
			Car a = carList.get(i);
			a.printCarMoving();
			System.out.println();
		}
	}
}
