package view;

enum CharEnums {
	KOREAN_START('ㄱ'), KOREAN_END('힣'), ENGLISH_START('A'), ENGLISH_END('z'), NUMBER_START('1'), NUMBER_END('9');
	private final char value;

	CharEnums(char value) {
		this.value = value;
	}

	public char getValue() {
		return this.value;
	}
}

enum StringEnums {
	DELIMITER(",");
	private final String value;

	StringEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

enum IntEnums {
	SIZE(5);
	private final int value;

	IntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

public class NameInputView {
}
