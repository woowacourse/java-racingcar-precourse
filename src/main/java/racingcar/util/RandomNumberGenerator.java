package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public static int generate() {
		return Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_MIN_VALUE, Constant.RANDOM_NUMBER_MAX_VALUE);
	}
}
