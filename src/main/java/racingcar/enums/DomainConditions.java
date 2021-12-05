package racingcar.enums;

public enum DomainConditions {
	MAX_CAR_NAME_LENGTH(5),
	EMPTY_CAR_NAME_LENGTH(0);

	private final int value;

	DomainConditions(int value) {
		this.value = value;
	}

	public int get() {
		return value;
	}
}
