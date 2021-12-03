package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

	private static int MIN_PICK_NUMBER = 0;
	private static int MAX_PICK_NUMBER = 9;

	public static int pickRandomNumber() {
		int pickNumber = Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
		return pickNumber;
	}
}
