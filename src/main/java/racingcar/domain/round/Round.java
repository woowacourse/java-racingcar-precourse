package racingcar.domain.round;

public class Round {
	private static final String ERR_NON_POSITIVE = "입력값이 양수가 아닙니다.";

	private int count = 0;

	public Round(int count) {
		validateInteger(count);
		this.count = count;
	}

	private static void validateInteger(int count) {
		validateZeroOrLess(count);
	}

	private static void validateZeroOrLess(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException(ERR_NON_POSITIVE);
		}
	}

	public boolean isOver() {
		return this.count <= 0;
	}

	public boolean decrease() {
		this.count--;
		return true;
	}
}
