package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
	public int roll() {
		final int MIN_RANDOM_NUM = 1;
		final int MAX_RANDOM_NUM = 9;
		return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
	}
}
