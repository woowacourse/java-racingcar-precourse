package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberBox {
	private static final int MIN = 0;
	private static final int MAX = 9;

	public static int getRandomNumber() {
		return pickNumberInRange(MIN, MAX);
	}
}
