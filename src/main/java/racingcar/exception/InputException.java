package racingcar.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputException {
	private static final String CAR_LAST_NAME_IS_COMMA = "[ERROR] 마지막 자동차 이름을 입력하지 않았습니다.";
	private static final String CAR_DUPLICATE_NAME = "[ERROR] 자동차 이름은 중복이 불가능합니다.";

	public static String[] isValidCarNames(String inputCarNames) {

		haveLastNameComma(inputCarNames);
		String[] carNames = inputCarNames.split(",");
		if (!haveDuplicateName(carNames)) {
			return carNames;
		}
		throw new IllegalArgumentException();
	}

	private static void haveLastNameComma(String carNames) {
		if (',' == carNames.charAt(carNames.length() - 1)) {
			throw new IllegalArgumentException(CAR_LAST_NAME_IS_COMMA);
		}
	}

	private static boolean haveDuplicateName(String[] carNames) {
		Set<String> names = new HashSet<>(Arrays.asList(carNames));
		if (names.size() != carNames.length) {
			throw new IllegalArgumentException(CAR_DUPLICATE_NAME);
		}
		return false;
	}
}
