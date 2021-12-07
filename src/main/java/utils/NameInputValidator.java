package utils;

import java.util.Arrays;

public class NameInputValidator {
	private static final char CHAR_COMMA = ',';
	private static final String STRING_COMMA = ",";
	private static final String BLANK = " ";
	private static final int MIN_CAR_COUNT = 2;
	private static final int MAX_CAR_NAME_COUNT = 5;
	private static final int MIN_CAR_NAME_COUNT = 1;
	private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름에 공백이 있다.";
	private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 중복되는 이름이 있다.";
	private static final String CAR_COUNT_ERROR_MESSAGE = "[ERROR] 입력한 자동차가 두대 미만 이다.";
	private static final String MAX_CAR_NAME_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 이름이 5글자가 넘는 자동차가 있다.";
	private static final String MIN_CAR_NAME_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 이름이 없는 경우가 있다.";
	private static final String LAST_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름 마지막 ',' 다음에 입력된 자동차 이름이 없다.";
	private static final String RE_INPUT_MESSAGE = "[ERROR] 다시 입력 하시오.";

	private NameInputValidator() {
	}

	public static String[] checkValidRacingCarNames(String inputRacingCarNames) {
		if (!isNoNameAfterComma(inputRacingCarNames)) {
			throw new IllegalArgumentException();
		}
		isNoNameAfterComma(inputRacingCarNames);
		String[] racingCarNames = inputRacingCarNames.split(STRING_COMMA);
		if (!hasBlankInRacingCarNames(racingCarNames) && !hasDuplicateNames(racingCarNames) && isMoreThanOneRacingCar(
			racingCarNames) && isValidRacingCarNamesLength(racingCarNames)) {
			return racingCarNames;
		}
		throw new IllegalArgumentException();
	}

	private static boolean hasBlankInRacingCarNames(String[] racingCarNames) {
		if (Arrays.stream(racingCarNames).anyMatch(racingCarName -> racingCarName.contains(BLANK))) {
			throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean hasDuplicateNames(String[] racingCarNames) {
		int racingCarNamesDistinctCount = (int)Arrays.stream(racingCarNames).distinct().count();
		if (racingCarNames.length != racingCarNamesDistinctCount) {
			throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isMoreThanOneRacingCar(String[] racingCarNames) {
		if (racingCarNames.length < MIN_CAR_COUNT) {
			throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isValidRacingCarNamesLength(String[] racingCarNames) {
		int notValidRacingCarNameCount = (int)Arrays.stream(racingCarNames)
			.filter(racingCarName -> isNotValidRacingCarNameLength(racingCarName))
			.count();
		if (notValidRacingCarNameCount == 0) {
			return true;
		}
		throw new IllegalArgumentException(RE_INPUT_MESSAGE);
	}

	private static boolean isNotValidRacingCarNameLength(String racingCarName) {
		if (racingCarName.length() > MAX_CAR_NAME_COUNT) {
			throw new IllegalArgumentException(MAX_CAR_NAME_ERROR_MESSAGE);
		}
		if (racingCarName.length() < MIN_CAR_NAME_COUNT) {
			throw new IllegalArgumentException(MIN_CAR_NAME_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isNoNameAfterComma(String racingCarNames) {
		int carNamesLastIndex = racingCarNames.length() - 1;
		if (CHAR_COMMA == racingCarNames.charAt(carNamesLastIndex)) {
			throw new IllegalArgumentException(LAST_INPUT_ERROR_MESSAGE);
		}
		return true;
	}
}
