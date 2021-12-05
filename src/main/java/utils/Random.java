package utils;

import static utils.Message.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static int generateRandomNumber() {
		return Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);
	}
}
