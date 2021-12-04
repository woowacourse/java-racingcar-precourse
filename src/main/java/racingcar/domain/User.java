package racingcar.domain;

import static racingcar.util.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Util;
import racingcar.util.Validation;

public class User {

	public String[] replyCars() {
		System.out.println(REPLY_CARS);
		String[] cars = Util.splitCars(Console.readLine());
		try {
			Validation.verifyCar(cars);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(ERROR_PREFIX + illegalArgumentException.getMessage());
			replyCars();
		}
		return cars;
	}
}
