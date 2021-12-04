package racingcar;

import java.util.Optional;

public class MoveCount {

	private final int count;

	public MoveCount(int count) {
		this.count = count;
	}

	public static Optional<MoveCount> Empty() {
		return Optional.empty();
	}
}
