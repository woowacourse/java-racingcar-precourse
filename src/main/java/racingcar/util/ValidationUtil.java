package racingcar.util;

import static racingcar.domain.Car.*;
import static racingcar.util.SymbolicConstantUtil.*;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {

	public static void isValidateBlank(String value) {
		if (value.contains(BLANK)) {
			throw new IllegalArgumentException("자동차명에 공백이 입력 되었습니다.");
		}
	}

	public static void isValidateLength(String value) {
		if (MINIMUM_CAR_NAME_LENGTH > value.length() || value.length() > MAXIMUM_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MINIMUM_CAR_NAME_LENGTH + "이상" + MAXIMUM_CAR_NAME_LENGTH + "이하 길이의 자동차명이 아닙니다.");
		}
	}

	public static void isValidateNotInput(String value) {
		if (value.equals(NOT_INPUT)) {
			throw new IllegalArgumentException("자동차명울 입력하지 않으셨습니다.");
		}
	}

	public static void isValidateDuplicated(String[] carsName) {
		Set<String> checkCarsName = new HashSet<>();
		for (String carName : carsName) {
			checkCarsName.add(carName);
		}
		if (checkCarsName.size() != carsName.length) {
			throw new IllegalArgumentException("입력된 자동차명에 중복된 이름이 있습니다.");
		}
	}
}
