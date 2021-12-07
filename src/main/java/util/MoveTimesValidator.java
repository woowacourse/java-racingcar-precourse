package util;

import view.OutputView;

public class MoveTimesValidator {
	private MoveTimesValidator() {
	}

	public static void validate(String moveTimes) {
		validateMoveTimesType(moveTimes);
		validatePositiveNumber(moveTimes);
	}

	private static void validateMoveTimesType(String moveTimes) {
		try {
			Integer.parseInt(moveTimes);
		} catch (NumberFormatException e) {
			OutputView.printMoveTimesTypeExceptionMessage();
			throw new IllegalArgumentException();
		}
	}

	private static void validatePositiveNumber(String moveTimes) {
		if (Integer.parseInt(moveTimes) < 0) {
			OutputView.printMoveTimesNegativeExceptionMessage();
			throw new IllegalArgumentException();
		}
	}
}
