package utils;

import static utils.Message.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static boolean checkForwardCondition() {
		int randomNumber = generateRandomNumber();

		return randomNumber >= FORWARD_CONDITION_NUMBER;
	}

	private static int generateRandomNumber() {
		return Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);
	}
}
