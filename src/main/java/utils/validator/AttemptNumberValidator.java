package utils.validator;

import static utils.Message.*;

public class AttemptNumberValidator {

	public static void validateAttemptNumber(String attemptNumber) {
		try {
			int number = Integer.parseInt(attemptNumber);
			validatePositiveNumber(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_FORMAT_MESSAGE);
		}
	}

	private static void validatePositiveNumber(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(NUMBER_NOT_POSITIVE_MESSAGE);
		}
	}
}
