package model;

public class Car {
	private static final int CAR_MOVE = 1;
	private static final int MIN_CONDITION_NUMBER = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveCar(int randomNumber) {
		if (possibleToMove(randomNumber)) {
			position += CAR_MOVE;
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
