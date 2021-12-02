package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {
	private static final int RANDOM_START_INCLUSIVE = 0;
	private static final int RANDOM_END_INCLUSIVE = 9;

	private RandomNumberPicker() {

	}

	public static int pickRandomNumber() {
		return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
	}
}
