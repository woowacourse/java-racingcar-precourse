package racingcar.util;

import racingcar.constant.RacingCarConst;

public class Validator {

	public static void validateCarName(String carName) {
		if (isEmptyString(carName)) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열 혹은 공백이면 안된다.");
		}

		if (greaterThanMaxLength(carName)) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
		}

	}

	private static boolean greaterThanMaxLength(String carName) {
		return carName.length() > RacingCarConst.NAME_MAX_LENGTH;
	}

	private static boolean isEmptyString(String carName) {
		return carName.trim().equals("");
	}
}
