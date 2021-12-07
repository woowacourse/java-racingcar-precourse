package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomForward {
	private static final int FORWARD_NUM = 4;
	private static final int startInclusive = 0;
	private static final int endInclusive = 9;

	public boolean isForward() {
		if (Randoms.pickNumberInRange(startInclusive, endInclusive) >= FORWARD_NUM) {
			return true;
		}
		return false;
	}
}
