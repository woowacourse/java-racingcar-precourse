package racingcar;

public class Verification {

	static final String EMPTY_NAME_ERROR = "[ERROR] 이름을 입력해야 한다.";
	static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
	static final String NOT_INTEGER_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";
	static final String ATTEMPT_SIZE_ERROR = "[ERROR] 시도 횟수는 1 이상이어야 한다.";

	static final String INTEGER = "-?\\d+";

	static final int MAX_NAME_LENGTH = 5;
	static final int MIN_ATTEMPT_SIZE = 1;

	public static void ofCarName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_NAME_ERROR);
		}

		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR);
		}
	}

	public static int ofAttempt(String attemptInput) {
		if (!attemptInput.matches(INTEGER)) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR);
		}

		int attempt = Integer.parseInt(attemptInput);

		if (attempt < MIN_ATTEMPT_SIZE) {
			throw new IllegalArgumentException(ATTEMPT_SIZE_ERROR);
		}

		return attempt;
	}
}
