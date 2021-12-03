package racingcar.util;

import static racingcar.util.Constants.*;

public class ValidChecker {

	public static void isValidCarNameLength(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throwIllegalArgumentException(ERROR_CAR_NAME_LENGTH_OVER);
		} else if (carName.length() < MIN_CAR_NAME_LENGTH) {
			throwIllegalArgumentException(ERROR_CAR_NAME_LENGTH_UNDER);
		}
	}

	public static void carExist(String[] cars) {
		if (cars.length < MIN_CAR_COUNT) {
			throwIllegalArgumentException(ERROR_CAR_COUNT_EMPTY);
		}
	}

	private static void throwIllegalArgumentException(String exceptionCase) {
		System.out.println(exceptionCase);
		throw new IllegalArgumentException(exceptionCase);
	}


}
