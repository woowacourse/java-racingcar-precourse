package racingcar;

import java.util.ArrayList;

public class Game {
	InputView inputView = new InputView();
	Cars cars = new Cars();

	public void run() {
		Racing();
	}

	private void Racing() {
		String[] carsNames = inputView.inputCarNames();
		cars.arrayOfObjects(carsNames);
	}

	public void findWinner(ArrayList<Car> cars) {
		int position = 0;

		for (Car car : cars) {
			if (car.getPosition() > position) {
				position = car.getPosition();
			}
		}
		printWinner(position, cars);
	}

	private void printWinner(int maxPosition, ArrayList<Car> cars) {
		StringBuffer winner = new StringBuffer();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winner.append(car.getName() + ",");
			}
		}
		Message.finalWinner(winner);
	}
}
