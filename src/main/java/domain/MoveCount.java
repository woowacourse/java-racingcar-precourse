package domain;

public class MoveCount {
	private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "시도 회수는 1 이상으로 입력해야 합니다.";

	private static final int MINIMUM_MOVE_COUNT = 1;

	private final int moveCount;

	private MoveCount(int moveCount) {
		validateRange(moveCount);
		this.moveCount = moveCount;
	}

	public static MoveCount from(String moveCount) {
		try {
			int convertedMoveCount = Integer.parseInt(moveCount);
			return new MoveCount(convertedMoveCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}

	public int toInt() {
		return this.moveCount;
	}

	private void validateRange(int moveCount) {
		if (moveCount < MINIMUM_MOVE_COUNT) {
			throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
		}
	}
}
