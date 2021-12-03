package racingcar.domain;

import java.util.Arrays;

public class InputValidation {

	public static final long ZERO = 0;
	public static final long CAR_NUM_MIN = 1;
	public static final long CAR_NUM_MAX = 1000;

	public static void checkCarNameValidation(String input, String splitRegex) {
		long carNameLengthValidation = Arrays.stream(input.split(splitRegex))
			.filter(carName -> carName.length() > 5 || carName.length() < 1)
			.count();
		long carNumberValidation = Arrays.stream(input.split(splitRegex)).count();

		if (checkCarNameConditions(carNameLengthValidation, carNumberValidation)) {
			throw new IllegalArgumentException();
		}
	}

	public static boolean checkCarNameConditions(long carNameLengthValidation, long carNumberValidation) {
		if (carNameLengthValidation == ZERO) {
			return false;
		}
		if (carNumberValidation < CAR_NUM_MIN) {
			return false;
		}
		if (carNumberValidation > CAR_NUM_MAX) {
			return false;
		}
		return true;
	}
}
