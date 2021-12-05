package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class FixedMovingStrategy implements MovingStrategy {

	private final boolean isMove;

	public FixedMovingStrategy(boolean isMove) {
		this.isMove = isMove;
	}

	@Override
	public boolean isMovable() {
		if (isMove) {
			return true;
		}
		return false;
	}
}
