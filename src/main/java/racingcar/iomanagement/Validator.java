package racingcar.iomanagement;

import java.util.regex.Pattern;

import racingcar.constant.Message;

public class Validator {
	public static void isCarNameLengthUnderFive(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException(Message.ERROR_LONG_CAR_NAME);
		}
	}

	public static void validateCountType(String count) {
		String regExp = "^[0-9]+$";

		if (!Pattern.matches(regExp, count)) {
			throw new IllegalArgumentException(Message.ERROR_COUNT_IS_INTEGER);
		}
	}

	public static void validateCountZero(String count) {
		if ("0".equals(count)) {
			throw new IllegalArgumentException(Message.ERROR_COUNT_CANNOT_BE_ZERO);
		}
	}
}
