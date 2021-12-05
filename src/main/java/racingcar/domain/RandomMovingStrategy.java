package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

	public static final int MOVING_THRESHOLD = 4;
	public static final int MINIMUM_MOVING_VALUE = 0;
	public static final int MAXIMUM_MOVING_VALUE = 9;

	@Override
	public boolean isMovable() {
		int randomNumbers = Randoms.pickNumberInRange(MINIMUM_MOVING_VALUE, MAXIMUM_MOVING_VALUE);
		if (randomNumbers >= MOVING_THRESHOLD) {
			return true;
		}
		return false;
	}
}
