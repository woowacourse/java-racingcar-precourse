package racingcar.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputException {
	private static final String LAST_INPUT_IS_COMMA = "[ERROR] 마지막 자동차 이름을 입력하지 않았습니다.";
	private static final String CAR_BLANK_INPUT_ERROR = "[ERROR] 자동차 이름에 공백은 사용이 불가능합니다.";
	private static final String CAR_NAME_SIZE = "[ERROR] 자동차 이름은 1자이상 5자이하만 가능합니다.";
	private static final String CAR_DUPLICATE_NAME = "[ERROR] 자동차 이름은 중복이 불가능합니다.";
	private static final int MIN_CAR_NAME_SIZE = 1;
	private static final int MAX_CAR_NAME_SIZE = 5;

	public static String[] isValidCarNames(String inputCarNames) {

		haveLastNameComma(inputCarNames);
		String[] carNames = inputCarNames.split(",");
		if (!haveBlankCarName(carNames) && isValidCarNameSize(carNames) && !haveDuplicateName(carNames)) {
			return carNames;
		}
		throw new IllegalArgumentException();
	}

	private static void haveLastNameComma(String carNames) {
		if (',' == carNames.charAt(carNames.length() - 1)) {
			throw new IllegalArgumentException(LAST_INPUT_IS_COMMA);
		}
	}

	private static boolean haveBlankCarName(String[] carNames) {
		for (String carName : carNames) {
			if (carName.contains(" ")) {
				throw new IllegalArgumentException(CAR_BLANK_INPUT_ERROR);
			}
		}
		return false;
	}

	private static boolean isValidCarNameSize(String[] carNames) {
		for (String carName : carNames) {
			if (carName.length() < MIN_CAR_NAME_SIZE || carName.length() > MAX_CAR_NAME_SIZE) {
				throw new IllegalArgumentException(CAR_NAME_SIZE);
			}
		}
		return true;
	}

	private static boolean haveDuplicateName(String[] carNames) {
		Set<String> names = new HashSet<>(Arrays.asList(carNames));
		if (names.size() != carNames.length) {
			throw new IllegalArgumentException(CAR_DUPLICATE_NAME);
		}
		return false;
	}

}
