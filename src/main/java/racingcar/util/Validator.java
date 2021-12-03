package racingcar.util;

import static racingcar.constant.GameConstants.*;

public class Validator {

	public void validateNumber(String number) {
		boolean isNumeric = number.matches(REGEX_EXPRESSION_OF_NUMBER);
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_MESSAGE);
		}
	}

	public void validateName(String name) {
		if (name.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException(NAMING_ERROR_MESSAGE);
		}
	}
}
