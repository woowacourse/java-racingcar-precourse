package racingcar.util;

import static racingcar.constant.GameConstants.*;

import java.util.List;

import racingcar.view.OutputView;

public class CarNameValidator {
	public static boolean isValidCarName(List<String> inputCarNames) {
		try {
			validateSize(inputCarNames);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private static void validateSize(List<String> inputCarNames) {
		if (inputCarNames.stream()
			.anyMatch(name -> name.length() > MAXIMUM_NAME_LENGTH)) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
	}
}
