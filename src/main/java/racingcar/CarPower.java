package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarPower {
	private static final int POWER_MIN = 0;
	private static final int POWER_MAX = 9;

	private CarPower() {
	}

	public static int getRandomPower() {
		return Randoms.pickNumberInRange(POWER_MIN, POWER_MAX);
	}
}
