package racingcar.domain;

import java.util.Arrays;

import racingcar.utils.Constant;
import racingcar.utils.ExceptionMessage;

public class ValidatorName {

	public static void isNull(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_NULL);
		}
	}

	public static void outOfLength(String name) {
		if (name.length() > Constant.CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_OUTOF_RANGE);
		}
	}

	public static void duplicate(String[] array_carNames) {
		long distinctSize = Arrays.stream(array_carNames).distinct().count();
		if (distinctSize < array_carNames.length) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATE);
		}
	}

}
