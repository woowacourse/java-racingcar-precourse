package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

public class Attempts {
	private static final String ERROR_NOT_INTEGER = "시도 횟수는 숫자여야 합니다.";
	private static final String ERROR_POSITIVE_NUMBER = "시도 횟수는 양수여야 합니다.";

	private Integer count;

	public void input() {
		String count = Console.readLine();
		validate(count);
	}

	private void validate(String count) {
		validateInteger(count);
		validatePositiveNumber();
	}

	private void validateInteger(String count) {
		try {
			this.count = Integer.parseInt(count);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}

	private void validatePositiveNumber() {
		if (count <= 0) {
			throw new IllegalArgumentException(ERROR_POSITIVE_NUMBER);
		}
	}
}
