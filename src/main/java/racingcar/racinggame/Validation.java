package racingcar.racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Validation {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String BLANK_NAME_ERROR = "자동차 이름은 빈칸일 수 없습니다.";
	private static final String DUPLICATE_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";

	private static final int MIN_NUMBER_OF_CARS = 1;

	public void isValid(String[] carNames) {
		isEmpty(carNames);
		isUnique(carNames);
		}

	private void isEmpty(String[] carNames) {
		if (carNames.length < MIN_NUMBER_OF_CARS) {
			throw new IllegalArgumentException(ERROR_MESSAGE + BLANK_NAME_ERROR);
		}
	}

	private void isUnique(String[] carNames) {
		ArrayList<String> names = new ArrayList<>(Arrays.asList(carNames));
		HashSet<String> unique = new HashSet<>(names);
		if (names.size() != unique.size()) {
			throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_NAME_ERROR);
		}
	}
}
