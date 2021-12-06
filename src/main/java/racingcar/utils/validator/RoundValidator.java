package racingcar.utils.validator;

import racingcar.utils.SystemMessage;

public class RoundValidator {
	public static int validate(String numStr) {
		int number;
		try {
			number = Integer.parseInt(numStr);
		} catch (Exception e) {
			throw new IllegalArgumentException(SystemMessage.ERROR_INPUT_ROUND_IS_NOT_NUMERIC);
		}

		if (!isPositiveNumber(number))
			throw new IllegalArgumentException(SystemMessage.ERROR_INPUT_ROUND_IS_NOT_POSITIVE_NUMBER);

		return number;
	}

	private static boolean isPositiveNumber(int number) {
		return number > 0;
	}
}
