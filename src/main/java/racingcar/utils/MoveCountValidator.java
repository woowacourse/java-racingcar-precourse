package racingcar.utils;

public class MoveCountValidator {

	public static final String ERROR_NOT_INTEGER = "[ERROR] 이동횟수는 숫자여야 합니다.";
	public static final String ERROR_ZERO_OR_NEGATIVE = "[ERROR] 이동횟수는 양수인 정수여야 합니다.";

	public void validateMove(String inputValue) {
		isInteger(inputValue);
		isPositive(inputValue);
	}

	private void isInteger(String inputValue) {
		try {
			Integer.parseInt(inputValue);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void isPositive(String inputValue) {
		int value = Integer.parseInt(inputValue);
		if (value <= 0) {
			throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE);
		}
	}
}

