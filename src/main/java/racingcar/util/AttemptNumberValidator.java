package racingcar.util;

import static racingcar.constant.GameConstants.*;

import racingcar.view.OutputView;

public class AttemptNumberValidator {
	public static boolean isValidAttemptNumber(String number) {
		try {
			validateNuber(number);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private static void validateNuber(String number) {
		if (!number.matches(ATTEMPT_NUMBER_REGEX)) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_REGEX_ERROR_MESSAGE);
		}
		try {
			Integer.parseInt(number);
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}
}
