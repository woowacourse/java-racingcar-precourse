package domain;

import utils.RandomNumber;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int moveCar(RandomNumber randomNumber) {
		int carMoveCount = randomNumber.getRandomNumber();
		if (carMoveCount >= 4) {
			this.position += carMoveCount;
		}

		return carMoveCount;
	}


}
