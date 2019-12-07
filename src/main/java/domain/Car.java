package domain;

import util.RandomNumber;

public class Car {
	private static final int REFERENCE_SIGNAL = 4;
	private static final String DISTANCE_MARK = "-";

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private void move() {
		position++;
	}

	private boolean hasSignal() {
		return RandomNumber.pick() >= REFERENCE_SIGNAL;
	}

	public void update() {
		if (hasSignal()) {
			move();
		}
	}

	@Override
	public String toString() {
		return name + " : " + DISTANCE_MARK.repeat(position);
	}
}
