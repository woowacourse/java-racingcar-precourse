package racingcar.service;

import static racingcar.constant.GameErrorMessage.*;

import racingcar.view.OutputView;

public class AttemptNumberService {
	public static boolean isValidInputNumber(String inputNumber) {
		try {
			int number = Integer.parseInt(inputNumber);
			validateNumberRange(number);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private static void validateNumberRange(int number) {
		if (number < 0) {
			throw new IllegalArgumentException();
		}
	}
}
