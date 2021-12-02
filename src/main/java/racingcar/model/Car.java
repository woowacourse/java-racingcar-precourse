package racingcar.model;

import racingcar.utils.RandomNumberPicker;

public class Car {
	private static final int MOVE_FORWARD_START_NUMBER = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getCarName() {
		return name;
	}

	public void moveForward() {
		if (RandomNumberPicker.pickRandomNumber() >= MOVE_FORWARD_START_NUMBER) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
