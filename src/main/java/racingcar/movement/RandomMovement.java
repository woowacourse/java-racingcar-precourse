package racingcar.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements MovementWay {
	private static final int MINIMUM_RANDOM_VALUE = 0;
	private static final int MAXIMUM_RANDOM_VALUE = 9;
	private static final int MINIMUM_MOVABLE_VALUE = 4;

	@Override
	public int getMovableDistance() {
		int value = Randoms.pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
		return getDistance(value);
	}

	private int getDistance(int value) {
		if (value < MINIMUM_MOVABLE_VALUE) {
			return 0;
		}
		return 1;
	}
}
