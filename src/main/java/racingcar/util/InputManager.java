package racingcar.util;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public static String[] readCarName() {
		String[] carNames;
		try {
			String stringLine = Console.readLine();
			carNames = stringLine.split(COMMA);
			checkStringLength(carNames);
		} catch (IllegalArgumentException exception) {
			carNames = readCarName();
		}
		return carNames;
	}

	private static void checkStringLength(String[] strings) {
		for (String string : strings) {
			ValidChecker.isValidCarNameLength(string);
		}
	}
}
