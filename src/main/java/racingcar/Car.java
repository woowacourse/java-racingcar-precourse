package racingcar;

import racingcar.util.RandomNumberGenerator;

public class Car {

	private static final int DRIVE_THRESHOLD_NUMBER = 4;

	private final String name;
	private int position = 0;
	private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void drive() {
		int randomNumber = randomNumberGenerator.generate();

		if (randomNumber >= DRIVE_THRESHOLD_NUMBER) {
			position++;
		}
	}

	public String showPosition() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}
}
