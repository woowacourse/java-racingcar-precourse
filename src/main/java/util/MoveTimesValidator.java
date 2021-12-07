package util;

public class MoveTimesValidator {
	private MoveTimesValidator() {
	}

	public static void validate(String moveTimes) {
		validateMoveTimes(moveTimes);
		validatePositiveNumber(moveTimes);
	}

	private static void validateMoveTimes(String moveTimes) {
		try {
			Integer.parseInt(moveTimes);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	private static void validatePositiveNumber(String moveTimes) {
		if (Integer.parseInt(moveTimes) < 0) {
			throw new IllegalArgumentException();
		}
	}
}
