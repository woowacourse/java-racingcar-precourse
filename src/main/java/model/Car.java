package model;

public class Car {
	private static final int MOVE_NUMBER = 1;
	private static final int MIN_CONDITION_NUMBER = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(int randomNumber) {
		if (possibleToMove(randomNumber)) {
			position += MOVE_NUMBER;
		}
	}

	private static boolean possibleToMove(int randomNumber) {
		if (randomNumber >= MIN_CONDITION_NUMBER) {
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
