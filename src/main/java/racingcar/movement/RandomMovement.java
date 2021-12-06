package racingcar.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements MovementWay {
	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;
	private static final int MIN_MOVABLE_VALUE = 4;

	@Override
	public int getMovableDistance() {
		int value = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
		return getDistance(value);
	}

	private int getDistance(int value) {
		if(value<MIN_MOVABLE_VALUE){
			return 0;
		}
		return 1;
	}
}
