package racingcar;

public enum ErrorMessage {
	ENGLISH_AND_COMMA_ONLY("자동차이름 입력 시 영문과 쉼표만 허용됩니다."),
	DUPLICATION_NOT_ALLOWED("자동차이름 입력 시 중복은 허용되지 않습니다."),
	NOT_ALLOWED_LENGTH_RANGE("자동차이름의 길이는 5이하만 허용됩니다."),
	INTEGER_ONLY_ALLOWED("반복 횟수는 자연수만 입력 가능합니다."),
	SHOULD_BIGGER_THAN_1("반복횟수는 1보다 커야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	//String START = "[ERROR]";

	public String get() {
		return "[ERROR] " + message;
	}
}