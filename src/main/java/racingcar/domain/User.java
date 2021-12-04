package racingcar.domain;

import static racingcar.util.Constant.*;

import racingcar.util.Util;
import racingcar.util.Validation;

public class User {

	public String[] getCars() {
		String[] cars = Util.getUserInput();
		try {
			Validation.verifyCar(cars);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(ERROR_PREFIX + illegalArgumentException.getMessage());
			getCars();
		}
		return cars;
	}
}
