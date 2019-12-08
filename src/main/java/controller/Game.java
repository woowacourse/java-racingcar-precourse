package controller;

import domain.Car;
import view.PrintMessage;

public class Game {
	private static final int MOVE_SIZE = 1;
	private static final int MOVE_CRITICAL_POINT = 4;
	private static int maximumPosition = 0;

	public void Start(Car[] car, int round) {
		while (round-- > 0) {
			moveCars(car);
			PrintMessage.printCar(car);
		}
		PrintMessage.printResult(car, maximumPosition);
	}

	private void moveCars(Car[] car) {
		for (int i = 0; i < car.length; i++) {
			moveCar(car[i]);
		}
	}

	private void moveCar(Car car) {
		int randomNumber = (int) (Math.random() * 10);
		int carPosition;
		if (randomNumber >= MOVE_CRITICAL_POINT) {
			carPosition = car.movePosition(MOVE_SIZE);
			checkMaximum(carPosition);
		}
	}

	private void checkMaximum(int carPosition) {
		if (maximumPosition < carPosition) {
			maximumPosition = carPosition;
		}
	}
}
