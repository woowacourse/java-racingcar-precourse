package racingcar.view;

import racingcar.util.Constants;

public class InputView {
	public static void getCarNames(String input) {
		String[] carNames = splitString(input);
		checkNameLength(carNames);
	}

	private static String[] splitString(String input) {
		return input.split(",");
	}

	private static void isValidLength(String[] carNames) {
		for (String name : carNames) {
			if (name.length() > Constants.CAR_NAME_MAX_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void checkNameLength(String[] carNames) {
		try {
			isValidLength(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.CAR_NAME_LENGTH_ERROR);
		}
	}

	public static int getAttemptsNum(String input) {
		isInteger(input);
		return Integer.parseInt(input);
	}

	public static void isInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ATTEMPTS_NUMBER_TYPE_ERROR);
		}
	}
}
