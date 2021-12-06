package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

	private InputValidator() {
	}

	public static void isValideRacingCarNames(String[] racingCarNames) {
		haveDuplicateNames(racingCarNames);
		isMoreThanOneRacingCar(racingCarNames);
		for (String racingCarName : racingCarNames) {
			isValideRacingCarNameLength(racingCarName);
		}
	}

	private static void isValideRacingCarNameLength(String racingCarName) {
		if (racingCarName.length() > 5) {
			throw new IllegalArgumentException("입력한 자동차 이름중 이름이 5글자가 넘는 자동차가 있다.");
		}

		if (racingCarName.length() < 1) {
			throw new IllegalArgumentException("입력한 자동차 이름중 이름이 없는 경우가 있다.");
		}

		if ((racingCarName == null) || (racingCarName.trim().length() == 0)) {
			throw new IllegalArgumentException("입력한 자동차 이름중 이름이 없는 경우가 있다.");
		}
	}

	private static void haveDuplicateNames(String[] racingCarNames) {
		int racingCarNamesCount = (int)Arrays.stream(racingCarNames).distinct().count();
		if (racingCarNames.length != racingCarNamesCount) {
			throw new IllegalArgumentException("입력한 자동차 이름중 중복되는 이름이 있다.");
		}
	}

	private static void isMoreThanOneRacingCar(String[] racingCarNames) {
		if (racingCarNames.length < 2) {
			throw new IllegalArgumentException("입력한 자동차가 두대 미만 이다.");
		}
	}
}
