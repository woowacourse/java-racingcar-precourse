package racingcar;

import utils.RandomUtils;

public class Car {
	private static final int MOVE_RANDOM_MIN_VALUE = 0;
	private static final int MOVE_RANDOM_MAX_VALUE = 9;
	private static final int MOVE_CRITERIA_VALUE = 4;

	private final StringBuilder movementBuilder;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.movementBuilder = new StringBuilder();
		movementBuilder.append(name).append(" : ");

		this.name = name;
	}

	public void movdOrStop() {
		int moveRandomValue = RandomUtils.nextInt(MOVE_RANDOM_MIN_VALUE, MOVE_RANDOM_MAX_VALUE);

		if (moveRandomValue >= MOVE_CRITERIA_VALUE) {
			position += 1;

			movementBuilder.append("-");
		}
	}

	@Override
	public String toString() {
		return movementBuilder.toString();
	}
}
