package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	static public int getRandomNumber(int start, int end) {
		return Randoms.pickNumberInRange(start, end);
	}
}
