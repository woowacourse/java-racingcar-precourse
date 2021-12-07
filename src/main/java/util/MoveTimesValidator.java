package util;

public class MoveTimesValidator {
	private MoveTimesValidator() {
	}

	public static void validate(String moveTimes) {
		validateMoveTimes(moveTimes);
	}

	private static void validateMoveTimes(String moveTimes) {
		try {
			Integer.parseInt(moveTimes);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
