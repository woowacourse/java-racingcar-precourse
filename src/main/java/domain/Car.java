/*
 * Car.java
 */

package domain;

class Car {
	private static final int MIN_MOVE_NUMBER = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void moveCar(int randomNumber) {
		if (randomNumber >= MIN_MOVE_NUMBER) {
			this.position++;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}
}
