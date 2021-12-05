package racingcar.type;

public enum RangeType {

	MAX_NAME_LENGTH(5),
	MIN_NAME_LENGTH(1),
	;

	private final int length;

	RangeType(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}
}
