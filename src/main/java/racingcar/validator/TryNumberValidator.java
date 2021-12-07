package racingcar.validator;

public class TryNumberValidator {
	static final String MSG_NOT_INTEGER_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";
	static final String MSG_NOT_POSITIVE_INTEGER_ERROR = "[ERROR] 시도 횟수는 양의 정수여야 한다.";

	public static void checkAll(String tryNumber) {
		isInteger(tryNumber);
		isPositiveInteger(tryNumber);
	}

	private static void isInteger(String tryNumber) {
		try {
			Integer.parseInt(tryNumber);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(MSG_NOT_INTEGER_ERROR);
		}
	}

	private static void isPositiveInteger(String tryNumber) {
		int tryNumberInt = Integer.parseInt(tryNumber);
		if (tryNumberInt <= 0) {
			throw new IllegalArgumentException(MSG_NOT_POSITIVE_INTEGER_ERROR);
		}
	}
}
