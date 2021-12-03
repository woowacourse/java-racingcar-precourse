package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	public static int getRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}
