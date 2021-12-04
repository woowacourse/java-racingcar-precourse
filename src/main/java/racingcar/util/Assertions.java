package racingcar.util;

import racingcar.ErrorInfo;

public class Assertions {
	private Assertions() {}

	public static void throwExceptionIsTrue(boolean condition, ErrorInfo errorInfo) {
		if (condition) {
			throw new IllegalArgumentException(errorInfo.getMessage());
		}
	}
}
