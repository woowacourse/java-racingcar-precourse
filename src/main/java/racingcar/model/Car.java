package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MOVE_FORWARD_START_NUMBER = 4;
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveForward() {
		if (pickRandomNumber() >= MOVE_FORWARD_START_NUMBER) {
			position++;
		}
	}

	private int pickRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}

	public String getCarName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
