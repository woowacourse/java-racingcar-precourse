package controller;

import domain.Car;
import view.PrintMessage;

public class Game {
	private static final int MOVE_SIZE = 1;

	public void Start(Car[] car, int round) {
		while (round-- > 0) {
			moveCars(car);
			PrintMessage.printCar(car);
		}
	}

	private void moveCars(Car[] car) {
		for (int i = 0; i < car.length; i++) {
			moveCar(car[i]);
		}
	}

	private void moveCar(Car car) {
		int randomNumber = (int) (Math.random() * 10);
		if (randomNumber >= 4) {
			car.movePosition(MOVE_SIZE);
		}
	}
}
