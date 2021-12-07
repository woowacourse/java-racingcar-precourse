package racingcar.domain.car;

public class Position {
	private static final String ERROR_NON_POSITIVE = "위치는 0 미만이 될 수 없습니다.";
	private int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		validatePosition(position);
		this.position = position;
	}

	private void validatePosition(int position) {
		if (position < 0) {
			throw new IllegalArgumentException(ERROR_NON_POSITIVE);
		}
	}
}
