package racingcar.utils;

public class Validator {
	private static final int NAME_LENGTH_LIMIT = 5;

	public static final String ERROR_LENGTH_MSG = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
	public static final String ERROR_NUMBER_MSG = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public static void validateNameInput(String[] names) {
		for (String name : names) {
			if (name.trim().length() > NAME_LENGTH_LIMIT || name.trim().length() == 0) {
				throw new IllegalArgumentException(ERROR_LENGTH_MSG);
			}
		}
	}

	public static void validateNumberInput(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NUMBER_MSG);
		}
	}
}
