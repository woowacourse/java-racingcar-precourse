package racingcar;

public class Validator {
	public static String validateName(String name) {
		if (isHighLength(name))
			throw new IllegalArgumentException(Const.ERROR_INPUT_CAR_NAME_LENGTH);

		if (isEmptyOrBlank(name))
			throw new IllegalArgumentException(Const.ERROR_INPUT_CAR_NAME_EMPTY_OR_BLANK);

		return name;
	}

	public static int validateRound(String numStr) {
		int number;
		try {
			number = Integer.parseInt(numStr);
		} catch (Exception e) {
			throw new IllegalArgumentException(Const.ERROR_INPUT_ROUND_IS_NOT_NUMERIC);
		}

		if (!isPositiveNumber(number))
			throw new IllegalArgumentException(Const.ERROR_INPUT_ROUND_IS_NOT_POSITIVE_NUMBER);

		return number;
	}

	private static boolean isHighLength(String name) {
		return name.length() > Const.MAX_NAME_COUNT;
	}

	private static boolean isEmptyOrBlank(String name) {
		return name.isEmpty() || name.trim().isEmpty();
	}

	private static boolean isPositiveNumber(int number) {
		return number > 0;
	}
}
