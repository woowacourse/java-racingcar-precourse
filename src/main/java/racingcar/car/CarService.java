package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;

	public static void accelerate(Car car) {
		int enginePower = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (enginePower > 4) {
			car.addPosition();
		}
	}
}
