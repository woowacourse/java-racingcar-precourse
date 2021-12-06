package racingcar.domain;

public class Position {
	private static final int MOVE_CONDITION = 4;

	private int value;

	public Position(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void isMove(RandomNumberGenerator generator) {
		if (generator.generate() >= MOVE_CONDITION) {
			this.value++;
		}
	}
}
