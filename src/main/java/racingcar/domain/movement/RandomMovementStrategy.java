package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {

	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;
	private static final int MOVE_THRESHOLD = 4;
	private static final int MOVE_DISTANCE = 1;
	private static final int STOP_DISTANCE = 0;

	@Override
	public int move() {
		if (isMovable()) {
			return MOVE_DISTANCE;
		}
		return STOP_DISTANCE;
	}

	private boolean isMovable() {
		return getRandom() >= MOVE_THRESHOLD;
	}

	private int getRandom() {
		return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
	}
}
