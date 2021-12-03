package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RandomProcess {

	public static void moveOrStand(Car car) {
		if (validateRandomNumber()) {
			car.goForward();
		}
	}

	private static boolean validateRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			return true;
		}
		return false;
	}
}
