package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {
	private static final String NUMBER_PATTERN = "^[0-9]*$";

	private InputValidator() {
	}

	public static String[] isValideRacingCarNames(String inputRacingCarNames) {
		isNoNameAfterComma(inputRacingCarNames);
		String[] racingCarNames = inputRacingCarNames.split(",");
		if (!haveBlankInRacingCarNames(racingCarNames) && !haveDuplicateNames(racingCarNames) && isMoreThanOneRacingCar(
			racingCarNames) && isValideRacingCarNamesLength(racingCarNames)) {
			return racingCarNames;
		}
		throw new IllegalArgumentException();
	}

	public static int isValideRaceCount(String raceCount) {
		if (raceCount.length() < 1) {
			throw new IllegalArgumentException("입력한 경주횟수가 없다");
		}

		if (raceCount.contains(" ")) {
			throw new IllegalArgumentException("입력한 경주횟수에 공백이 있다.");
		}

		if (!Pattern.matches(NUMBER_PATTERN, raceCount)) {
			throw new IllegalArgumentException("입력한 경주횟수가 숫자가 아니다.");
		}

		if (raceCount.startsWith("0")) {
			throw new IllegalArgumentException("입력한 경주횟수가 0으로 시작한다.");
		}

		return Integer.parseInt(raceCount);
	}

	private static boolean haveBlankInRacingCarNames(String[] racingCarNames) {
		for (String racingCarName : racingCarNames) {
			haveBlankInRacingCarName(racingCarName);
		}
		return false;
	}

	private static void haveBlankInRacingCarName(String racingCarName) {
		if (racingCarName.contains(" ")) {
			throw new IllegalArgumentException("입력한 자동차 이름에 공백이 있습니다.");
		}
	}

	private static boolean haveDuplicateNames(String[] racingCarNames) {
		int racingCarNamesCount = (int)Arrays.stream(racingCarNames).distinct().count();
		if (racingCarNames.length != racingCarNamesCount) {
			throw new IllegalArgumentException("입력한 자동차 이름중 중복되는 이름이 있다.");
		}
		return false;
	}

	private static boolean isMoreThanOneRacingCar(String[] racingCarNames) {
		if (racingCarNames.length < 2) {
			throw new IllegalArgumentException("입력한 자동차가 두대 미만 이다.");
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
		if (racingCarName.length() > 5) {
			throw new IllegalArgumentException("입력한 자동차 이름중 이름이 5글자가 넘는 자동차가 있다.");
		}

		if (racingCarName.length() < 1) {
			throw new IllegalArgumentException("입력한 자동차 이름중 이름이 없는 경우가 있다.");
		}

	}

	private static void isNoNameAfterComma(String racingCarNames) {
		if (',' == racingCarNames.charAt(racingCarNames.length() - 1)) {
			throw new IllegalArgumentException("입력한 자동차 이름 마지막 ',' 다음에 입력된 자동차 이름이 없다.");
		}
	}
}
