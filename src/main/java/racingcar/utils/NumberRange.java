package racingcar.utils;

public enum NumberRange {

	MINIMUM(0), MAXIMUM(9);

	private final int number;

	NumberRange(int number) {
		this.number = number;
	}

	public static int getMinimum() {
		return MINIMUM.number;
	}

	public static int getMaximum() {
		return MAXIMUM.number;
	}

}
