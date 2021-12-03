package racingcar.util;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public static String[] readCarName() {
		String[] carNames;
		try {
			String stringLine = Console.readLine();
			carNames = stringLine.split(COMMA);
			checkCarName(carNames);
		} catch (IllegalArgumentException exception) {
			carNames = readCarName();
		}
		return carNames;
	}

	private static void checkCarName(String[] strings) {
		checkStringLength(strings);
		checkCarExist(strings);
	}

	private static void checkStringLength(String[] strings) {
		for (String string : strings) {
			ValidChecker.isValidCarNameLength(string);
		}
	}

	private static void checkCarExist(String[] strings) {
		ValidChecker.carExist(strings);
	}
}
