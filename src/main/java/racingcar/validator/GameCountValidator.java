package racingcar.validator;

import static constants.RacingCarConstant.*;

public class GameCountValidator {
	public static void checkGameCount(String gameCount) {
		isEmpty(gameCount);
		isDigit(gameCount);
		isUpperZero(gameCount);
	}

	private static void isEmpty(String gameCount) {
		if (gameCount.isEmpty()) {
			throw new IllegalArgumentException(GAME_COUNT_EMPTY_ERROR);
		}
	}

	private static void isDigit(String gameCount) {
		for (int i = 0; i < gameCount.length(); i++) {
			char tmpGameCount = gameCount.charAt(i);
			if (!Character.isDigit(tmpGameCount)) {
				throw new IllegalArgumentException(GAME_COUNT_NOT_DIGIT_ERROR);
			}
		}
	}

	private static void isUpperZero(String gameCount) {
		int tmpGameCount = Integer.parseInt(gameCount);
		if (tmpGameCount <= 0)
			throw new IllegalArgumentException(GAME_COUNT_UPPER_ZERO_ERROR);
	}
}
