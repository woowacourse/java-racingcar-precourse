package racingcar.utils;

public class InputTryCountValidator {
	private static final String INPUT_TRY_COUNT_PATTERN = "^[0-9]*$";
	private static final String INPUT_TRY_COUNT_LENGTH_ERROR_MESSAGE = "[ERROR] 시도 회수를 입력해주세요.";
	private static final String INPUT_TRY_COUNT_PATTERN_ERROR_MESSAGE = "[ERROR] 시도 회수는 숫자만 가능합니다.";

	private final String inputTryCount;

	public InputTryCountValidator(String inputTryCount) {
		this.inputTryCount = inputTryCount;
	}

	public void validateInputTryCount() {
		checkInputTryCountLength();
		checkInputTryCountPattern();
	}

	private void checkInputTryCountLength() {
		if (inputTryCount.length() < 1) {
			throw new IllegalArgumentException(INPUT_TRY_COUNT_LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkInputTryCountPattern() {
		if (!inputTryCount.matches(INPUT_TRY_COUNT_PATTERN)) {
			throw new IllegalArgumentException(INPUT_TRY_COUNT_PATTERN_ERROR_MESSAGE);
		}
	}
}
