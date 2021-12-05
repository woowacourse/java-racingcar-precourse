package domain;

public class TryCount {
	private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "시도 회수는 1 이상으로 입력해야 합니다.";

	private static final int MINIMUM_TRY_COUNT = 1;

	private final int tryCount;

	private TryCount(int tryCount) {
		validateRange(tryCount);
		this.tryCount = tryCount;
	}

	public static TryCount from(String tryCount) {
		try {
			int convertedTryCount = Integer.parseInt(tryCount);
			return new TryCount(convertedTryCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}

	public int toInt() {
		return this.tryCount;
	}

	private void validateRange(int tryCount) {
		if (tryCount < MINIMUM_TRY_COUNT) {
			throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
		}
	}
}
