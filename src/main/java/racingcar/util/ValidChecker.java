package racingcar.util;

import static racingcar.util.Constants.*;

public class ValidChecker {

	public static void isValidCarNameLength(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throwIllegalArgumentException(ERROR_CAR_NAME_LENGTH_OVER);
		} else if (carName.length() < 1) {
			throwIllegalArgumentException(ERROR_CAR_NAME_LENGTH_UNDER);
		}
	}

	private static void throwIllegalArgumentException(String exceptionCase) {
		System.out.println(exceptionCase);
		throw new IllegalArgumentException(exceptionCase);
	}
}
