package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	private static final int MAX_NUMBER = 9;
	private static final int MIN_NUMBER = 0;

	private RandomNumberGenerator() {
	}

	public static int makeRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
