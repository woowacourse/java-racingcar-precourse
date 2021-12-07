package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	private static final int RANDOM_NUM_MIN = 0;
	private static final int RANDOM_NUM_MAX = 9;

	public static int getRandomNum() {
		int randomNum = Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
		return randomNum;
	}
}
