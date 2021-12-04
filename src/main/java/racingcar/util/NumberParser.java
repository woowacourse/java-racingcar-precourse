package racingcar.util;

import racingcar.ErrorInfo;

public class NumberParser {

	private NumberParser() {}

	public static int parseInt(String string) {
		if (string.chars().allMatch(Character::isDigit)) {
			return Integer.parseInt(string);
		}
		throw new IllegalArgumentException(ErrorInfo.NUMBER.getMessage());
	}
}
