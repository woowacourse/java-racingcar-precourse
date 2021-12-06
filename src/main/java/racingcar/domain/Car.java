package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int MOVABLE_THRESHOLD = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveAccordingToRule() {
		if (isMovable()) {
			move();
		}
	}

	private boolean isMovable() {
		int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		return randomNumber >= MOVABLE_THRESHOLD;
	}

	private void move() {
		position++;
	}
}
