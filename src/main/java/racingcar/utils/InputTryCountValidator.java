package racingcar.utils;

public class InputTryCountValidator {
	private static final String PATTERN = "^[0-9]*$";
	private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 시도 회수를 입력해주세요.";
	private static final String PATTERN_ERROR_MESSAGE = "[ERROR] 시도 회수는 숫자만 가능합니다.";

	private final String inputTryCount;

	public InputTryCountValidator(String inputTryCount) {
		this.inputTryCount = inputTryCount;
	}

	public void validate() {
		checkLength();
		checkPattern();
	}

	private void checkLength() {
		if (inputTryCount.length() < 1) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkPattern() {
		if (!inputTryCount.matches(PATTERN)) {
			throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
		}
	}
}
