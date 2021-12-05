package utils.validator;

import static utils.Message.*;

import java.util.Arrays;

public class CarNameValidator {

	public static void validateCarName(String[] carNames) {
		for (String carName : carNames) {
			validateBlank(carName);
			validateLength(carName);
		}
		validateDuplication(carNames);
	}

	private static void validateBlank(String carName) {
		if ((carName == null) || (carName.trim().length() == 0)) {
			throw new IllegalArgumentException(NAME_BLANK_MESSAGE);
		}
	}

	private static void validateLength(String carName) {
		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEED_MESSAGE);
		}
	}

	private static void validateDuplication(String[] carNames) {
		long count = Arrays.stream(carNames)
			.distinct()
			.count();

		if (carNames.length != count) {
			throw new IllegalArgumentException(NAME_DUPLICATION_MESSAGE);
		}
	}
}
