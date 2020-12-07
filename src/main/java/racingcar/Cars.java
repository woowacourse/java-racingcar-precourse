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
		carListRacing(carList);
	}

	private void carListRacing(ArrayList<Car> carList) {
		InputView inputView = new InputView();
		int count = inputView.inputChooseRacingCount();
		Message.executionResult();
		
		while (count != 0) {
			for (int i = 0; i < carList.size(); i++) {
				Car car = carList.get(i);
				car.printCarMoving();
			}
			count--;
			System.out.println();
		}
	}

}
