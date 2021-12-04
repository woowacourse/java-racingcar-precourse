package racingcar;

public class Verification {

	static final String EMPTY_NAME_ERROR = "[ERROR] 이름을 입력해야 한다.";
	static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하여야 한다.";

	static final int MAX_NAME_LENGTH = 5;

	public static void ofCarName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_NAME_ERROR);
		}

		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR);
		}
	}
}
