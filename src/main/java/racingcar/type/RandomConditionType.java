package racingcar.type;

public enum RandomConditionType {
	MIN_NUMBER_RANGE(0),
	MAX_NUMBER_RANGE(9),
	MOVABLE_CONDITION_NUMBER(4);

	private final int randomCondition;

	RandomConditionType(int randomCondition) {
		this.randomCondition = randomCondition;
	}

	public int getRandomCondition() {
		return randomCondition;
	}
}
