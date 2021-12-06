package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
	private int MIN_RANDOM_NUM = 1;
	private int MAX_RANDOM_NUM = 9;

	public int roll() {
		return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
	}
}
