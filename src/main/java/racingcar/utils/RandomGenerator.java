package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.ConstantNum.*;

public class RandomGenerator {
	private final int RANDOM_NUM_MIN = 0;
	private final int RANDOM_NUM_MAX = 9;

	public int getRandomNum() {
		int randomNum = Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
		return randomNum;
	}
}
