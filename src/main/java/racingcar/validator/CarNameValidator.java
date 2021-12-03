package racingcar.validator;

import static constants.RacingCarConstant.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
	public static void checkCarNameInput(String carNameInput) {
		if (carNameInput.isEmpty()) {
			throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR);
		}

		for (int idx = 1; idx < carNameInput.length(); idx++) {
			if (carNameInput.charAt(idx) == DELIMITER_CHARACTER
				&& carNameInput.charAt(idx - 1) == DELIMITER_CHARACTER) {
				throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR);
			}
		}
		if (carNameInput.charAt(carNameInput.length() - 1) == DELIMITER_CHARACTER) {
			throw new IllegalArgumentException(CAR_NAME_WRONG_END_ERROR);
		}
	}

	public static void checkCarNames(String[] carNames) {
		isDuplicate(carNames);
		isRightLength(carNames);
	}

	private static void isDuplicate(String[] carNames) {
		Set<String> checkedNames = new HashSet<>();
		checkedNames.addAll(Arrays.asList(carNames));
		if (checkedNames.size() != carNames.length) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
		}
	}

	private static void isRightLength(String[] carNames) {
		for (String carName : carNames) {
			if (carName.length() < 1 || carName.length() > 5) {
				throw new IllegalArgumentException(CAR_NAME_WRONG_LENGTH_ERROR);
			}
		}
	}
}
