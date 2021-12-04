package racingcar.domain;

import static racingcar.util.Constant.*;

import racingcar.util.Util;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean isGoing(int value) {
		return value >= MOVING_FORWARD;
	}

	public void move() {
		int random = Util.getRandomNumber(RANDOM_START, RANDOM_END);
		if (isGoing(random)) {
			movePosition();
		}
	}

	private void movePosition() {
		position++;
	}

	public String repeatWord(String word, int count) {
		StringBuilder output = new StringBuilder();
		for (int current = 0; current < count; current++) {
			output.append(word);
		}
		return output.toString();
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return name + " : " + repeatWord("-", position);
	}

	public String getName() {
		return name;
	}
}
