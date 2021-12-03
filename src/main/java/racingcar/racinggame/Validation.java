package racingcar.racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Validation {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String BLANK_NAME_ERROR = "자동차 이름은 빈칸일 수 없습니다.";
	private static final String DUPLICATE_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";
	private static final String LONG_NAME_ERROR = "자동차 이름은 5자 이하여야 합니다.";
	private static final String SHORT_NAME_ERROR = "자동차 이름은 1자 이상이어야 합니다.";
	private static final String CONTAINS_BLANK_ERROR = "자동차 이름에 공백이 포함될 수 없습니다.";
	private static final String NOT_DIGIT_ERROR = "라운드 횟수는 정수여야 합니다.";

	private static final int MIN_NUMBER_OF_CARS = 1;
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MIN_CAR_NAME_LENGTH = 1;
	private static final String BLANK = " ";

	public void isValid(String[] carNames) {
		isEmpty(carNames);
		isUnique(carNames);
		for (String carName : carNames) {
			tooLong(carName);
			tooShort(carName);
			hasBlank(carName);
		}
	}

	public void isValid(String round) {
		for (int i = 0; i < round.length(); i++) {
			notDigit(round, i);
		}
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

	private void tooLong(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ERROR_MESSAGE + LONG_NAME_ERROR);
		}
	}

	private void tooShort(String carName) {
		if (carName.length() < MIN_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ERROR_MESSAGE + SHORT_NAME_ERROR);
		}
	}

	private void hasBlank(String carName) {
		if (carName.contains(BLANK)) {
			throw new IllegalArgumentException(ERROR_MESSAGE + CONTAINS_BLANK_ERROR);
		}
	}

	private void notDigit(String round, int i) {
		if (!Character.isDigit(round.charAt(i))) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIGIT_ERROR);
		}
	}
}
