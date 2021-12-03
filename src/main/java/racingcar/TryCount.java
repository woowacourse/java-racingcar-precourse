package racingcar;

import static java.lang.String.*;

public class TryCount {
	private static final int TRY_COUNT_MIN = 1;
	private static final String COUNT_RANGE_ERROR = format("[ERROR] 시도 회수는 %d 이상이어야 합니다", TRY_COUNT_MIN);

	private int tryCount;

	public TryCount(int tryCount) {
		checkRange(tryCount);
		this.tryCount = tryCount;
	}

	public void checkRange(int tryCount) {
		if (tryCount < TRY_COUNT_MIN) {
			throw new IllegalArgumentException(COUNT_RANGE_ERROR);
		}
	}

	public boolean canTry() {
		return tryCount >= TRY_COUNT_MIN;
	}

	public void use() {
		tryCount--;
	}
}
