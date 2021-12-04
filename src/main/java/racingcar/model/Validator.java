package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	private static final int CAR_NAME_MIN_LENGTH = 1;
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 1자 이상, 5자 이하여야합니다.";
	private static final String CAR_NAMES_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차는 2대 이상이어야합니다.";
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
	private static final String PATTERN = "^[0-9]*$";
	private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 시도 회수를 입력해주세요.";
	private static final String PATTERN_ERROR_MESSAGE = "[ERROR] 시도 회수는 숫자만 가능합니다.";


	private static Set<String> carNamesSet;

	private Validator() {}

	public static boolean isCarNamesValidated(String[] carNames) {
		try {
			validateCarNames(carNames);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void validateCarNames(String[] carNames) {
		checkCarNameLength(carNames);
		checkCarNamesLength(carNames);
		checkCarNamesDuplicate(carNames);
	}

	private static void checkCarNameLength(String[] carNames) {
		for (String carName : carNames) {
			throwCarNameLengthException(carName);
		}
	}

	private static void throwCarNameLengthException(String carName) {
		if (carName.length() < CAR_NAME_MIN_LENGTH || carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private static void checkCarNamesLength(String[] carNames) {
		if (carNames.length < 2) {
			throw new IllegalArgumentException(CAR_NAMES_LENGTH_ERROR_MESSAGE);
		}
	}

	private static void checkCarNamesDuplicate(String[] carNames) {
		carNamesSet = new HashSet<>();
		for (String carName : carNames) {
			throwCarNamesDuplicateException(carName);
		}
	}

	private static void throwCarNamesDuplicateException(String carName) {
		if (carNamesSet.contains(carName)) {
			throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR_MESSAGE);
		}
		carNamesSet.add(carName);
	}

	public static boolean isTryCountValidated(String inputTryCount) {
		try {
			validateTryCount(inputTryCount);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void validateTryCount(String inputTryCount) {
		checkLength(inputTryCount);
		checkPattern(inputTryCount);
	}

	private static void checkLength(String inputTryCount) {
		if (inputTryCount.length() < 1) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private static void checkPattern(String inputTryCount) {
		if (!inputTryCount.matches(PATTERN)) {
			throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
		}
	}
}
