package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NUM = 0;
	private static final int RANDOM_MAX_NUM = 9;
	private static final int MOVE_FORWARD_MIN = 4;
	private static final String STRING_JOIN_DELIMITER = " : ";
	private static final String MOVE_EXPRESSION = "-";

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void moveForward() {
		if (Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MOVE_FORWARD_MIN) {
			this.position++;
		}
	}

	public int positionComparator(int position) {
		return Integer.compare(this.position, position);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(this.name + STRING_JOIN_DELIMITER);
		for (int i = 0; i < this.position; i++) {
			result.append(MOVE_EXPRESSION);
		}
		return result.toString();
	}
}
