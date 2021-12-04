package racingcar.view;

import racingcar.util.Constants;

public class InputView {
	public static String[] splitString(String input) {
		String[] result = input.split(",");
		isValidLength(result);
		return result;
	}

	private static void isValidLength(String[] carNames) {
		for (String name : carNames) {
			if (name.length() > Constants.CAR_NAME_MAX_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static int parseInt(String input) {
		isInteger(input);
		return Integer.parseInt(input);
	}

	private static void isInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
