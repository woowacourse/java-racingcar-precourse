package racingcar.iomanagement;

import java.util.regex.Pattern;

import racingcar.constant.Message;
import racingcar.constant.Number;

public class Validator {
	public static String validateCarNameLengthUnderFive(String carName) {
		if (carName.length() > Number.NAME_LENGTH) {
			throw new IllegalArgumentException(Message.ERROR_LONG_CAR_NAME);
		}
		return carName;
	}

	public static void validateCountType(String count) {
		String numberOnly = "^[0-9]+$";

		if (!Pattern.matches(numberOnly, count)) {
			throw new IllegalArgumentException(Message.ERROR_COUNT_IS_INTEGER);
		}
	}

	public static void validateCountZero(String count) {
		if (Number.ZERO_STRING.equals(count)) {
			throw new IllegalArgumentException(Message.ERROR_COUNT_CANNOT_BE_ZERO);
		}
	}
}
