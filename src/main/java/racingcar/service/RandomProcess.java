package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RandomProcess {

	public static final int THRESHOLD = 4;
	public static final int START_INCLUSIVE = 0;
	public static final int END_INCLUSIVE = 9;

	public static void moveOrStand(Car car) {
		if (validateRandomNumber()) {
			car.goForward();
		}
	}

	private static boolean validateRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		return randomNumber >= THRESHOLD;
	}
}
