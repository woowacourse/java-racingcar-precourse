package racingcar.domain;

import static racingcar.resource.MessageResoruce.*;

public class Round {
	private static final int MIN_NUMBER = 1;

	private final int round;

	public Round(String inputRound) {
		if (!isNumeric(inputRound)) {
			throw new IllegalArgumentException(ERROR_ROUND_NUMBER_NOT_VALID);
		}
		if (Integer.parseInt(inputRound) < MIN_NUMBER) {
			throw new IllegalArgumentException(ERROR_ROUND_NUMBER_GREATER_THAN_ZERO);
		}
		this.round = Integer.parseInt(inputRound);
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
