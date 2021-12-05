package racingcar.service;

import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameErrorMessage.*;

import racingcar.view.OutputView;

public class AttemptNumberService {
	public static boolean isValidAttemptNumber(String number) {
		try {
			validateNumber(number);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private static void validateNumber(String number) {
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
