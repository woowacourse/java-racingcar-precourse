package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

	public static final int MOVING_THRESHOLD = 4;

	@Override
	public boolean isMovable() {
		int randomNumbers = Randoms.pickNumberInRange(0, 9);
		if (randomNumbers >= MOVING_THRESHOLD) {
			return true;
		}
		return false;
	}
}
