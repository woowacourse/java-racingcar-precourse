package racingcar.game.model;

import racingcar.common.message.ExceptionMessage;

public class TryNumber {
	private static final int ZERO = 0;
	private final int tryNumber;

	public TryNumber(final String tryNumber) {
		final int parsedNumber = isValidFormat(tryNumber);
		isValidPositive(parsedNumber);
		this.tryNumber = parsedNumber;
	}

	private int isValidFormat(final String tryNumber) {
		try {
			return Integer.parseInt(tryNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.TRY_NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private void isValidPositive(final int parsedNumber) {
		if (parsedNumber <= ZERO) {
			throw new IllegalArgumentException(ExceptionMessage.TRY_NUMBER_POSITIVE_EXCEPTION_MESSAGE.getMessage());
		}

	}

	public int getTryNumber() {
		return this.tryNumber;
	}

}
