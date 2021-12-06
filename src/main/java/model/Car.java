package model;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(int randomNumber) {
		if (possibleToMove(randomNumber)) {
			position += 1;
		}
	}

	private static boolean possibleToMove(int randomNumber) {
		if (randomNumber >= 4) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
