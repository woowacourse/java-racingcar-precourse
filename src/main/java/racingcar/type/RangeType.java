package racingcar.type;

public enum RangeType {

	MAX_NAME_LENGTH(5),
	MIN_NAME_LENGTH(1),
	ZERO(0),
	MAX_RANDOM_NUMBER(9),
	MOVABLE_NUMBER(4),
	;

	private final int value;

	RangeType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
