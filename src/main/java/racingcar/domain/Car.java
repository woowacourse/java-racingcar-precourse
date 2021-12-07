package racingcar.domain;

import racingcar.utils.RandomGenerator;

import static racingcar.utils.ConstantNum.*;

public class Car {
	private final String carName;
	private int position = 0;

	private final int PROCEED_NUM_MIN = 4;

	public Car(String carName) {
		this.carName = carName;
	}

	public void proceedOrPause() {
		RandomGenerator randomGenerator = new RandomGenerator();
		if (randomGenerator.getRandomNum() >= PROCEED_NUM_MIN) {
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