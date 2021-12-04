package racingcar;

import java.util.Optional;
import racingcar.util.Assertions;

public class MoveCount {
	private static final int MAX_COUNT = 100;

	private final int count;

	public MoveCount(int count) {
		Assertions.throwExceptionIsTrue(count > MAX_COUNT, ErrorInfo.MAX);
		this.count = count;
	}

	public static Optional<MoveCount> Empty() {
		return Optional.empty();
	}
}
