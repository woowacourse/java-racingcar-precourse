package view;

enum TurnStringEnums {
	TURN_REGEX("^[0-9]+$");
	private final String value;

	TurnStringEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

enum TurnIntEnums {
	TURN_MIN(0);
	private final int value;

	TurnIntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}


public class TurnInputView {
}
