package racingcar;

import utils.RandomUtils;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	protected void stopOrGo() {
		if (RandomUtils.nextInt(0, 9) >= 4)
			position++;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
