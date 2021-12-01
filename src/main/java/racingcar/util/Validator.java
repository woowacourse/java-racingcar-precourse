package racingcar.util;

import racingcar.constant.ErrorMessage;

public class Validator {

	public static void isLengthOverFive(String input) {
		if (input.length() > 5) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH_OVER_FIVE);
		}
	}
}
