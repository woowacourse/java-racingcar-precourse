package util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
	private static final int MIN_CAR_NAME_LENGTH = 1;
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private CarNameValidator() {
	}

	public static void validate(String[] carNames) {
		validateCarNameLength(carNames);
		validateDuplicateCarName(carNames);
	}

	private static void validateCarNameLength(String[] carNames) {
		for (String car : carNames) {
			if (car.length() < MIN_CAR_NAME_LENGTH || car.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void validateDuplicateCarName(String[] carNames) {
		Set<String> uniqueCarNames = new HashSet<>();
		Collections.addAll(uniqueCarNames, carNames);

		if (uniqueCarNames.size() != carNames.length) {
			throw new IllegalArgumentException();
		}
	}
}
