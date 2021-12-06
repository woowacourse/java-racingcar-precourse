package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratePolicy implements NumberGeneratePolicy {
	private static final int MINIMUM_DRIVE = 0;
	private static final int MAXIMUM_DRIVE = 9;

	@Override
	public int generateNumber() {
		return Randoms.pickNumberInRange(MINIMUM_DRIVE, MAXIMUM_DRIVE);
	}
}
