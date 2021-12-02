package racingcar.validator;

import java.util.stream.Stream;

import racingcar.util.Constant;

public class InputValidator {
	public static boolean checkCarNameLength(String carName) {
		return carName.length() >= Constant.CAR_NAME_MIN_SIZE
			&& carName.length() <= Constant.CAR_NAME_MAX_SIZE;
	}

	public static boolean checkAttemptIsNumber(String attempt) {
		return Stream.of(attempt.split(""))
			.map(c -> c.charAt(0))
			.allMatch(Character::isDigit);
	}
}
