package util;

public class CarNameValidator {
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private CarNameValidator() {
	}

	public static void validate(String[] carNames) {
			validateCarNameLength(carNames);
	}

	public static void validateCarNameLength(String[] carNames) {
		for (String car : carNames) {
			if (car.length() >= MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}
}
