package racingcar.type;

public enum NameType {
	MAX_NAME_LENGTH(5);

	private final int type;

	NameType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}

