package racingcar.service;

import static racingcar.message.GuideMessage.*;

public class NumberValidation {

	public static void validateInputNumber(String inputString) {
		String regex = "[1-9]+";

		if (inputString.matches(regex)) {
			throw new IllegalArgumentException(ERR_INTEGER);
		}
	}
}
