package racingcar.utils;

import java.util.Arrays;

public class Validator {
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int ZERO = 0;

	private static final String ERROR_LENGTH_MSG = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
	private static final String ERROR_DUP_MSG = "[ERROR] 자동차 이름이 중복되었다.";
	private static final String ERROR_NUMBER_MSG = "[ERROR] 시도 횟수는 숫자여야 한다.";
	private static final String ERROR_ZERO_MSG = "[ERROR] 시도 횟수는 1회 이상이어야 한다.";

	public static void validateNameInput(String[] names) throws IllegalArgumentException {
		validateNameLength(names);
		validateDuplicatedName(names);
	}

	private static void validateNameLength(String[] names) {
		Arrays.stream(names).forEach(name -> {
			if (name.trim().length() > NAME_LENGTH_LIMIT || name.trim().length() == ZERO) {
				throw new IllegalArgumentException(ERROR_LENGTH_MSG);
			}
		});
	}

	private static void validateDuplicatedName(String[] names) {
		if (names.length != Arrays.stream(names).distinct().count()) {
			throw new IllegalArgumentException(ERROR_DUP_MSG);
		}
	}

	public static void validateNumberInput(String input) throws IllegalArgumentException {
		try {
			validateZero(Integer.parseInt(input));
		} catch (NumberFormatException e) {
			// 숫자가 아니면 발생하는 NumberFormatException 처리
			throw new IllegalArgumentException(ERROR_NUMBER_MSG);
		}
	}

	private static void validateZero(int input) throws NumberFormatException {
		if (input == ZERO) {
			throw new IllegalArgumentException(ERROR_ZERO_MSG);
		}
	}
}
