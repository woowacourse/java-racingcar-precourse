package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	public int getRandomNum() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
