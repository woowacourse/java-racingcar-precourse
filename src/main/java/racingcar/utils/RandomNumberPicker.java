package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private RandomNumberPicker() {

	}

	public static int pick() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}
