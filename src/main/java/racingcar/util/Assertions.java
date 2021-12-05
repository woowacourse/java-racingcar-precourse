package racingcar.util;

import racingcar.error.ErrorMessage;

public class Assertions {
	private Assertions() {}

	public static void throwExceptionIsTrue(boolean condition, ErrorMessage errorMessage) {
		if (condition) {
			throw new IllegalArgumentException(errorMessage.getMessage());
		}
	}
}
