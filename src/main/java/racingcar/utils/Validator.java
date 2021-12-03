package racingcar.utils;

import java.util.regex.Pattern;

import racingcar.exception.CarNameNotValidException;
import racingcar.exception.NumberFormatNotValidException;

public class Validator {
	private static final Pattern NUMBER = Pattern.compile("[0-9]+");
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int CAR_MOVE_CONDITION_MIN_VALUE = 4;

	public static boolean validateCarNames(String[] carNames, boolean flag) {
		try {
			for (int i = 0; i < carNames.length; i++) {
				String name = carNames[i];
				isNameLengthMoreOverThanLimit(name);
			}
		} catch (IllegalArgumentException ex) {
			flag = false;
		}
		return flag;
	}

	public static boolean validateNumberFormat(String input, boolean flag) {
		try {
			isNumberFormat(input);
		} catch (IllegalArgumentException ex) {
			flag = false;
		}
		return flag;
	}

	public static boolean validateCarMoveCondition(int randomNumber) {
		if (randomNumber >= CAR_MOVE_CONDITION_MIN_VALUE) {
			return true;
		}
		return false;
	}

	private static void isNumberFormat(String input) {
		if (!NUMBER.matcher(input).matches()) {
			throw new NumberFormatNotValidException();
		}
	}

	private static void isNameLengthMoreOverThanLimit(String name) {
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new CarNameNotValidException();
		}
	}

}
