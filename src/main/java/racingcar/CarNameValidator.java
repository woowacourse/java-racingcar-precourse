package racingcar;

import static racingcar.view.InputView.*;

import java.util.Arrays;

public class CarNameValidator {

	public static void validateEveryCarName(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));	}

	private static void validateCarName(String eachCarName) {
		if (eachCarName.length() > CAR_NAME_LETTERS_STANDARD) {
			throw new IllegalArgumentException(
				String.format(CAR_NAME_OVER_STANDARD_ERROR_MESSAGE, CAR_NAME_LETTERS_STANDARD));
		}
		if (eachCarName.isEmpty()) {
			throw new IllegalArgumentException(CAR_NAME_NOT_NULL_ERROR_MESSAGE);
		}
	}

	public static void hasNoCarNameAtLast(String inputValue) {
		if (inputValue.endsWith(CAR_SPLIT_REGEX)) {
			throw new IllegalArgumentException(CAR_NAME_NOT_NULL_ERROR_MESSAGE);
		}
	}
}
