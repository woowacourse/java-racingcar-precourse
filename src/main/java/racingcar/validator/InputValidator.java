package racingcar.validator;

import racingcar.util.Constant;

public class InputValidator {
	public static boolean checkCarNameLength(String carName) {
		return carName.length() >= Constant.CAR_NAME_MIN_SIZE
			&& carName.length() <= Constant.CAR_NAME_MAX_SIZE;
	}
}
