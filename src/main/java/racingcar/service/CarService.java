package racingcar.service;

import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameErrorMessage.*;

import java.util.List;

import racingcar.view.OutputView;

public class CarService {
	public static boolean isValidCarName(List<String> inputCarNames) {
		try {
			checkWhiteSpaceName(inputCarNames);
			checkSize(inputCarNames);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private static void checkWhiteSpaceName(List<String> inputCarNames) {
		if (inputCarNames.stream()
			.anyMatch(CarService::isWhiteSpace)) {
			throw new IllegalArgumentException(WHITE_SPACE_NAME_ERROR_MESSAGE);
		}
	}

	private static boolean isWhiteSpace(String name) {
		String trimmedName = name.trim();
		return trimmedName.length() == 0;
	}

	private static void checkSize(List<String> inputCarNames) {
		if (inputCarNames.stream()
			.anyMatch(CarService::isInvalidNameSize)) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private static boolean isInvalidNameSize(String name) {
		return name.length() > MAXIMUM_NAME_LENGTH || name.length() == 0;
	}
}
