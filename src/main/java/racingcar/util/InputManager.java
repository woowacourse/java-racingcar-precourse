package racingcar.util;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public static String[] readCarName() {
		System.out.println(MESSAGE_INPUT_CAR_NAMES);
		String[] carNames;
		do {
			carNames = Console.readLine().split(COMMA);
		} while (!checkCarName(carNames));
		return carNames;
	}

	public static int readDriveCount() {
		System.out.println(MESSAGE_INPUT_DRIVE_COUNT);
		String readLine;
		do {
			readLine = Console.readLine();
		} while (!checkDriveCount(readLine));
		return Integer.parseInt(readLine);
	}

	private static boolean checkCarName(String[] strings) {
		try {
			checkStringLength(strings);
			ValidChecker.carExist(strings);
			ValidChecker.isDistinctCarName(strings);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static void checkStringLength(String[] strings) {
		for (String string : strings) {
			ValidChecker.isValidCarNameLength(string);
		}
	}

	private static boolean checkDriveCount(String string) {
		try {
			checkStringIsNumber(string);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static void checkStringIsNumber(String string) {
		ValidChecker.isValidStringForNumber(string);
	}
}
