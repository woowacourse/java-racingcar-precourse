package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class CarNamesValidator {
	private static final int CAR_NAME_MIN_LENGTH = 1;
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 1자 이상, 5자 이하여야합니다.";
	private static final String CAR_NAMES_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차는 2대 이상이어야합니다.";
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

	private final String[] carNames;
	private Set<String> carNamesSet;

	public CarNamesValidator(String[] carNames) {
		this.carNames = carNames;
	}

	public void validate() {
		checkCarNameLength();
		checkCarNamesLength();
		checkCarNamesDuplicate();
	}

	private void checkCarNameLength() {
		for (String carName : carNames) {
			throwCarNameLengthException(carName);
		}
	}

	private void throwCarNameLengthException(String carName) {
		if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkCarNamesLength() {
		if (carNames.length < 2) {
			throw new IllegalArgumentException(CAR_NAMES_LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkCarNamesDuplicate() {
		carNamesSet = new HashSet<>();
		for (String carName : carNames) {
			throwCarNamesDuplicateException(carName);
		}
	}

	private void throwCarNamesDuplicateException(String carName) {
		if (carNamesSet.contains(carName)) {
			throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
		}
		carNamesSet.add(carName);
	}
}
