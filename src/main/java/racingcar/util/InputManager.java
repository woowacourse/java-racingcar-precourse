package racingcar.util;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public static String[] readCarName() {
		System.out.println(MESSAGE_INPUT_CAR_NAMES);
		String[] carNames;
		try {
			carNames = Console.readLine().split(COMMA);
			checkCarName(carNames);
		} catch (IllegalArgumentException exception) {
			carNames = readCarName();
		}
		return carNames;
	}

	public static int readDriveCount() {
		System.out.println(MESSAGE_INPUT_DRIVE_COUNT);
		int driveCount;
		try {
			String readLine = Console.readLine();
			checkDriveCount(readLine);
			driveCount = Integer.parseInt(readLine);
		} catch (IllegalArgumentException exception) {
			driveCount = readDriveCount();
		}
		return driveCount;
	}

	private static void checkCarName(String[] strings) {
		checkStringLength(strings);
		ValidChecker.carExist(strings);
		ValidChecker.isDistinctCarName(strings);
	}

	private static void checkStringLength(String[] strings) {
		for (String string : strings) {
			ValidChecker.isValidCarNameLength(string);
		}
	}

	private static void checkDriveCount(String string) {
		checkStringIsNumber(string);
	}

	private static void checkStringIsNumber(String string) {
		ValidChecker.isValidStringForNumber(string);
	}
}
