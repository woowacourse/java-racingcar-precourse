package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar() {

		if (getRandomNumber() > 3) {
			position++;
		}

	}

	private int getRandomNumber() {
		return (int)(Math.random() * 10);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
