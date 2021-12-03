package racingcar;

import static java.lang.String.*;

public class TryCountValidator {
	private static final int TRY_COUNT_MIN = 1;
	private static final String COUNT_RANGE_ERROR = format("[ERROR] 시도 회수는 %d 이상이어야 합니다", TRY_COUNT_MIN);

	private TryCountValidator() {
	}

	public static void validate(int tryCount) {
		if (tryCount < TRY_COUNT_MIN) {
			throw new IllegalArgumentException(COUNT_RANGE_ERROR);
		}
	}
}
