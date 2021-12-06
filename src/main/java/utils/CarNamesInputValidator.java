package utils;

import java.util.Arrays;

public class CarNamesInputValidator {
	private static final char CHAR_COMMA = ',';
	private static final String STRING_COMMA = ",";
	private static final String BLANK = " ";
	private static final int MIN_CAR_COUNT = 2;
	private static final int MAX_CAR_NAME_NUMBER = 5;
	private static final int MIN_CAR_NAME_NUMBER = 1;
	private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름에 공백이 있다.";
	private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 중복되는 이름이 있다.";
	private static final String CAR_COUNT_ERROR_MESSAGE = "[ERROR] 입력한 자동차가 두대 미만 이다.";
	private static final String MAX_CAR_NAME_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 이름이 5글자가 넘는 자동차가 있다.";
	private static final String MIN_CAR_NAME_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름중 이름이 없는 경우가 있다.";
	private static final String LAST_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름 마지막 ',' 다음에 입력된 자동차 이름이 없다.";

	private CarNamesInputValidator() {
	}

	public static String[] isValideRacingCarNames(String inputRacingCarNames) {
		isNoNameAfterComma(inputRacingCarNames);
		String[] racingCarNames = inputRacingCarNames.split(STRING_COMMA);
		if (!haveBlankInRacingCarNames(racingCarNames) && !haveDuplicateNames(racingCarNames) && isMoreThanOneRacingCar(
			racingCarNames) && isValideRacingCarNamesLength(racingCarNames)) {
			return racingCarNames;
		}
		throw new IllegalArgumentException();
	}

	private static boolean haveBlankInRacingCarNames(String[] racingCarNames) {
		for (String racingCarName : racingCarNames) {
			haveBlankInRacingCarName(racingCarName);
		}
		return false;
	}

	private static void haveBlankInRacingCarName(String racingCarName) {
		if (racingCarName.contains(BLANK)) {
			throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
		}
	}

	private static boolean haveDuplicateNames(String[] racingCarNames) {
		int racingCarNamesCount = (int)Arrays.stream(racingCarNames).distinct().count();
		if (racingCarNames.length != racingCarNamesCount) {
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

	private static boolean isValideRacingCarNamesLength(String[] racingCarNames) {
		for (String racingCarName : racingCarNames) {
			isValideRacingCarNameLength(racingCarName);
		}
		return true;
	}

	private static void isValideRacingCarNameLength(String racingCarName) {
		if (racingCarName.length() > MAX_CAR_NAME_NUMBER) {
			throw new IllegalArgumentException(MAX_CAR_NAME_ERROR_MESSAGE);
		}
		if (racingCarName.length() < MIN_CAR_NAME_NUMBER) {
			throw new IllegalArgumentException(MIN_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private static void isNoNameAfterComma(String racingCarNames) {
		int carNamesLastIndex = racingCarNames.length() - 1;
		if (CHAR_COMMA == racingCarNames.charAt(carNamesLastIndex)) {
			throw new IllegalArgumentException(LAST_INPUT_ERROR_MESSAGE);
		}
	}
}
