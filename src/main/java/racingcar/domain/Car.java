package racingcar.domain;

import static racingcar.util.Constant.*;

import racingcar.util.Util;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean isGoing(int value) {
		if (value >= 4) {
			return true;
		}
		return false;
	}

	public void move() {
		int random = Util.getRandomNumber(RANDOM_START, RANDOM_END);
		if (isGoing(random)) {
			this.position++;
		}
	}

	@Override
	public String toString() {
		return "123";
	}
}
