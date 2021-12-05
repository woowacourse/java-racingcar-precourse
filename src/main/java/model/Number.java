package model;

enum NumberIntEnums {
	RANDOM_NUMBER_START(0), RANDOM_NUMBER_END(9);
	private final int value;

	NumberIntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

public class Number {
	private int randomNumber;

	public Number() {
		this.randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(
			NumberIntEnums.RANDOM_NUMBER_START.getValue(), NumberIntEnums.RANDOM_NUMBER_END.getValue());
	}

	public boolean overThisValue(int threshold) {
		return this.randomNumber > threshold;
	}
}
