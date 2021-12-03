package racingcar.util;

import static racingcar.util.Constants.*;

import java.util.Arrays;

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

	public static void isDistinctCarName(String[] carNames) {
		long distinctCarCount = Arrays.stream(carNames).distinct().count();
		if (carNames.length != distinctCarCount) {
			throwIllegalArgumentException(ERROR_SAME_CAR_NAME);
		}
	}

	public static void isValidStringForNumber(String string) {
		char[] charArray = string.toCharArray();
		for (char digit : charArray) {
			isValidCharacterForNumber(digit);
		}
		isNumberPositive(Integer.parseInt(string));
	}

	private static void isValidCharacterForNumber(char digit) {
		if (digit > MAX_CHAR_FOR_NUMBER || digit < MIN_CHAR_FOR_NUMBER) {
			throwIllegalArgumentException(ERROR_CHAR_IS_NOT_NUMBER);
		}
	}

	private static void isNumberPositive(int number) {
		if (number < MIN_DRIVE_COUNT) {
			throwIllegalArgumentException(ERROR_DRIVE_COUNT_INVALID);
		}
	}

	private static void throwIllegalArgumentException(String exceptionCase) {
		System.out.println(exceptionCase);
		throw new IllegalArgumentException(exceptionCase);
	}
}
