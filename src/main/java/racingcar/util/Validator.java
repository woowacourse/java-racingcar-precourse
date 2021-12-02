package racingcar.util;

import java.util.List;

public class Validator {
	private static final int CAR_NAME_RESTRICTIONS_MIN = 1;
	private static final int CAR_NAME_RESTRICTIONS_MAX = 5;

	public void checkCarNamesInput(List<String> carNames) throws IllegalArgumentException {
		for (String carName : carNames) {
			if (CAR_NAME_RESTRICTIONS_MAX < carName.length()) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 한다.");
			}
			if (carName.length() < CAR_NAME_RESTRICTIONS_MIN) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 한다.");
			}
		}
	}
}
