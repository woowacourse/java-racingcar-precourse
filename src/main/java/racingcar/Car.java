package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NUM = 0;
	private static final int RANDOM_MAX_NUM = 9;
	private static final int MOVE_FORWARD_MIN = 4;

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

	public void moveForward() {
		if (Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MOVE_FORWARD_MIN) {
			this.position++;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(this.name + " : ");
		for (int i = 0; i < this.position; i++) {
			result.append("-");
		}
		return result.toString();
	}
}
