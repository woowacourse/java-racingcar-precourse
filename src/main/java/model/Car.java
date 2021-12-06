package model;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(int randomNumber) {
		if (randomNumber >= 4) {
			position += 1;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
