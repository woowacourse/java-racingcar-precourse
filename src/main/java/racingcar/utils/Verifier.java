package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

import racingcar.constants.Constant;

public class Verifier {

	private Verifier() {
	}

	public static void checkLastIndex(String userInput) {
		if (userInput.lastIndexOf(Constant.IMPROPER_CHARACTER) == userInput.length() - 1) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkValidNames(String[] names) {
		Set<String> namesSet = new HashSet<>();
		for (String name : names) {
			if (!isValidNameLength(name) || isDuplicated(namesSet, name)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static boolean isDuplicated(Set<String> names, String name) {
		return !names.add(name);
	}

	private static boolean isValidNameLength(String name) {
		return Constant.MIN_NAME_LENGTH <= name.length() && name.length() <= Constant.MAX_NAME_LENGTH;
	}

	public static int checkValidStage(String input) {
		if (isNumber(input)) {
			int stage = Integer.parseInt(input);
			if (stage != 0) {
				return stage;
			}
		}

		throw new IllegalArgumentException();
	}

	private static boolean isNumber(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
