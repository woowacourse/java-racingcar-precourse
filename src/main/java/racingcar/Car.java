package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_RANGE_START = 0;
	private static final int RANDOM_RANGE_END = 9;
	private static final int MINIMUM_MOVABLE_INT = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void goForwardByRandom() {
		if (isMovable()) {
			position += 1;
		}
	}

	private boolean isMovable() {
		int pick = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
		if (pick >= MINIMUM_MOVABLE_INT) {
			return true;
		}
		return false;
	}
}
