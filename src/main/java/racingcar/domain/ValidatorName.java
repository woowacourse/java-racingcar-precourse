package racingcar.domain;

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

}
