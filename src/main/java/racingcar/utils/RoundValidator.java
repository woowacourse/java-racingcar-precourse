package racingcar.utils;

public class RoundValidator {
	public static int validate(String numStr) {
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

	private static boolean isPositiveNumber(int number) {
		return number > 0;
	}
}
