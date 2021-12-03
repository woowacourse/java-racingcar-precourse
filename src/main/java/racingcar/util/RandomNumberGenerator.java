package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	private static final int RANDOM_NUMBER_RANGE_MIN = 0;
	private static final int RANDOM_NUMBER_RANGE_MAX = 9;

	public int generate() {
		int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUMBER_RANGE_MAX);
		return randomNumber;
	}
}
