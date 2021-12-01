package utils;

import static utils.Message.*;

import java.util.Arrays;

public class Validator {

	public static void validateCarName(String[] carNames) {
		for (String carName : carNames) {
			if (validateBlank(carName)) {
				throw new IllegalArgumentException(NAME_BLANK_MESSAGE);
			}

			if (!validateLength(carName)) {
				throw new IllegalArgumentException(NAME_LENGTH_EXCEED_MESSAGE);
			}
		}

		if (!validateDuplication(carNames)) {
			throw new IllegalArgumentException(NAME_DUPLICATION_MESSAGE);
		}
	}

	public static void validateAttemptNumber(String attemptNumber) {
		try {
			int number = Integer.parseInt(attemptNumber);

			if (!validatePositiveNumber(number)) {
				throw new IllegalArgumentException(NUMBER_NOT_POSITIVE_MESSAGE);
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_FORMAT_MESSAGE);
		}
	}

	private static boolean validateBlank(String carName) {
		return (carName == null) || (carName.trim().length() == 0);
	}

	private static boolean validateLength(String carName) {
		return carName.length() <= 5;
	}

	private static boolean validateDuplication(String[] carNames) {
		long count = Arrays.stream(carNames).distinct().count();

		return carNames.length == count;
	}

	private static boolean validatePositiveNumber(int number) {
		return 0 < number;
	}
}
