package racingcar.utils;

import java.util.List;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public static boolean checkCarNameLength(List<String> carNameList) {
		for (String carName : carNameList) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				return false;
			}
		}
		return true;
	}
}
