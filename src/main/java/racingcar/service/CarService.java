package racingcar.service;

import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameErrorMessage.*;

import java.util.List;

import racingcar.view.OutputView;

public class CarService {
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
			.anyMatch(CarService::isOversizeName)) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
	}

	private static boolean isOversizeName(String name) {
		return name.length() > MAXIMUM_NAME_LENGTH;
	}
}
