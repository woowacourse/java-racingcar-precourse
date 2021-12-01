package racingcar;

import java.util.Arrays;

public class Validator {
	public static void validateCarInput(String input) {
		String[] cars = input.split(",");
		for (String car : cars) {
			checkCarNameLength(car);
		}
	}

	private static void checkCarNameLength(String name) {
		if (name.length() > 5 || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateTurnInput(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
