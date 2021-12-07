package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;

public class CarNameValidator {
	static final int CAR_NAME_LENGTH = 5;
	static final String MSG_EMPTY_LIST_ERROR = "[ERROR] 자동차 이름은 한 개 이상이어야 한다.";
	static final String MSG_DUPLICATION_ERROR = "[ERROR] 자동차 이름은 중복될 수 없다.";
	static final String MSG_INVALID_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하만 가능하다.";
	static final String MSG_EMPTY_NAME_ERROR = "[ERROR] 자동차 이름은 공백일 수 없다.";

	public static void checkAll(String[] carNames) {
		isEmptyList(carNames);
		checkDuplication(carNames);
		for (String carName : carNames) {
			checkLength(carName);
			isEmptyName(carName);
		}
	}

	private static void isEmptyList(String[] carNames) {
		if (carNames.length == 0) {
			throw new IllegalArgumentException(MSG_EMPTY_LIST_ERROR);
		}
	}

	private static void checkDuplication(String[] carNames) {
		HashSet<String> carNamesSet = new HashSet<>(Arrays.asList(carNames));
		if (carNames.length != carNamesSet.size()) {
			throw new IllegalArgumentException(MSG_DUPLICATION_ERROR);
		}
	}

	private static void checkLength(String carName) {
		if (carName.length() > CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(MSG_INVALID_LENGTH_ERROR);
		}
	}

	private static void isEmptyName(String carName) {
		if (carName.equals("")) {
			throw new IllegalArgumentException(MSG_EMPTY_NAME_ERROR);
		}
	}
}
