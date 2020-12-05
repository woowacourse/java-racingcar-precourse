package utils;

public class RoundInputValidator {
	private static final Integer ZERO = 0;
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String NUMBERFORMAT_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
	private static final String RANGE_ERROR_MESSAGE = "시도 횟수는 1이상이여야 합니다.";

	public static void inputVaildCheck(String round) {
		if (!isNumber(round)) {
			throw new IllegalArgumentException(ERROR_PREFIX + NUMBERFORMAT_ERROR_MESSAGE);
		}
		if (!isRightRange(round)) {
			throw new IllegalArgumentException(ERROR_PREFIX + RANGE_ERROR_MESSAGE);
		}
	}

	public static boolean isNumber(String round) {
		try {
			Integer.parseInt(round);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isRightRange(String round) {
		if (Integer.parseInt(round) <= ZERO) {
			return false;
		}
		return true;
	}
}
