package racingcar;

public class Car {

	private static final int DRIVE_STANDARD_NUMBER = 4;

	private final String name;
	private int position = 0;

	private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	public Car(String name) {
		this.name = name;
	}

	public void drive() {
		int randomNumber = randomNumberGenerator.generate();

		if (randomNumber >= DRIVE_STANDARD_NUMBER) {
			position++;
		}
	}
}
