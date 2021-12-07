package racingcar.utils;

import static racingcar.controller.InputController.*;

public class InputValidation {
	private static final String IS_ZERO_ERROR_MESSAGE = "회수는 최소 한번 이상이여야 한다.";
	private static final String IS_NUMBER_ERROR_MESSAGE = "회수는 숫자여야 한다.";
	private static final String CONTAIN_DELIMITER_ERROR_MESSAGE = NAME_DELIMITER + "가 포함되어야 한다.";
	private static final String SIZE_ERROR_MESSAGE = "자동차 이름은 최소 2개이상 입력해야 한다.";

	public static void validateIsZero(String input) throws IllegalArgumentException {
		if (Integer.parseInt(input) == 0) {
			throw new IllegalArgumentException(IS_ZERO_ERROR_MESSAGE);
		}
	}

	public static void validateIsNumber(String input) throws IllegalArgumentException {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException(IS_NUMBER_ERROR_MESSAGE);
			}
		}
	}

	public static void validateContainDelimiter(String input) throws IllegalArgumentException {
		if (!input.contains(NAME_DELIMITER)) {
			throw new IllegalArgumentException(CONTAIN_DELIMITER_ERROR_MESSAGE);
		}
	}

	public static void validateSize(String[] names) throws IllegalArgumentException {
		if (names.length < 2) {
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		}
	}

}
