package racingcar.domain;

public enum NumberRange {
	MIN_NO(0), MAX_NO(9);
	private final int value;

	NumberRange(int value) {
		this.value = value;
	}
	public int getValue() {
		return Integer.parseInt(String.valueOf(value));
	}
}
