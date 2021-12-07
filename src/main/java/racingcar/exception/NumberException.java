package racingcar.exception;

import static racingcar.constant.Message.*;

public class NumberException {
	public static void checkNumberException(String input) {
		checkIntException(input);
		checkMinNumberException(input);
	}

	private static void checkIntException(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_TRY_NUMBER);
		}
	}

	private static void checkMinNumberException(String input) {
		int num = Integer.parseInt(input);
		if (num < 1) {
			throw new IllegalArgumentException(ERROR_TRY_MIN);
		}
	}
}

