package utils;

import java.util.regex.Pattern;

public class CountInputValidator {
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private static final String BLANK = " ";
	private static final int MIN_RACE_COUNT = 1;
	private static final String ZERO = "0";
	private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력한 경주횟수에 공백이 있다.";
	private static final String NOT_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 경주횟수가 없다";
	private static final String NOT_RIGHT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 경주횟수가 올바른수(양수)가 아니다.";
	private static final String START_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 경주횟수가 0으로 시작한다.";

	private CountInputValidator() {
	}

	public static int isValideRaceCount(String raceCount) {
		if (!haveBlankInRaceCount(raceCount) && !isNullRaceCount(raceCount) && isRightNumber(raceCount)) {
			return Integer.parseInt(raceCount);
		}
		throw new IllegalArgumentException();
	}

	private static boolean haveBlankInRaceCount(String raceCount) {
		if (raceCount.contains(BLANK)) {
			throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isNullRaceCount(String raceCount) {
		if (raceCount.length() < MIN_RACE_COUNT) {
			throw new IllegalArgumentException(NOT_INPUT_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isRightNumber(String raceCount) {
		if (!Pattern.matches(NUMBER_PATTERN, raceCount)) {
			throw new IllegalArgumentException(NOT_RIGHT_NUMBER_ERROR_MESSAGE);
		}
		if (raceCount.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_NUMBER_ERROR_MESSAGE);
		}
		return true;
	}
}
