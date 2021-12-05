package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_RANGE_START = 0;
	private static final int RANDOM_RANGE_END = 9;
	private static final int MINIMUM_MOVABLE_INT = 4;

	private final String name;
	private int position = 0;
	private StringBuilder stringBuilder = new StringBuilder();

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
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

	public void printStatus() {
		System.out.println(buildStatusString());
	}

	private String buildStatusString() {
		stringBuilder.setLength(0);
		stringBuilder.append(name).append(' ').append(':').append(' ');
		for (int i = 0; i < position; i++) {
			stringBuilder.append('-');
		}
		return stringBuilder.toString();
	}
}
