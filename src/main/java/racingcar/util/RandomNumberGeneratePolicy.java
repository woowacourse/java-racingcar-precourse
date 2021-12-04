package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratePolicy extends NumberGeneratePolicy {

	@Override
	public int generateNumber() {
		return Randoms.pickNumberInRange(MINIMUM_DRIVE, MAXIMUM_DRIVE);
	}
}
