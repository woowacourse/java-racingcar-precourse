package domain;

public class Car {
	public static final int START_POSITION = 0;
	private static final int MAX_STOP_NUMBER = 3;
	private static final int MAX_RANDOM_NUMBER = 9;

	private final String name;
	private int position = START_POSITION;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar() {

		if (getRandomNumber() > MAX_STOP_NUMBER) {
			position++;
		}

	}

	private int getRandomNumber() {
		return (int)(Math.random() * (MAX_RANDOM_NUMBER + 1));
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
