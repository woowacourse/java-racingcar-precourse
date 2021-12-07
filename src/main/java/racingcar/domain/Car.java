package racingcar.domain;

import racingcar.utils.RandomGenerator;

public class Car {
	private final String carName;
	private int position = 0;

	private final int PROCEED_NUM_MIN = 4;

	public Car(String carName) {
		this.carName = carName;
	}

	public void proceedOrPause() {
		if (RandomGenerator.getRandomNum() >= PROCEED_NUM_MIN) {
			this.position++;
		}
	}

	public String getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}
}