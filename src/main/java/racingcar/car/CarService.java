package racingcar.car;

import static racingcar.constant.NumberConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
	public static void accelerate(Car car) {
		int enginePower = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (enginePower >= MOVE_STANDARD_POINT) {
			car.addPosition();
		}
	}
}
