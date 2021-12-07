package racingcar.domain;

public class DefaultRule implements MoveRule {
	private static final int MOVABLE_THRESHOLD = 4;

	@Override
	public boolean isMovable(int number) {
		return number >= MOVABLE_THRESHOLD;
	}
}
