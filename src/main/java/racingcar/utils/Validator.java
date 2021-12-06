package racingcar.utils;


import java.util.HashSet;
import java.util.List;

import racingcar.view.OutputView;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final int CAR_NAME_LIST_MIN_SIZE = 2;

	public static boolean isValidCarName(List<String> carNameList) {
		if (!checkCarNameListSize(carNameList)) {
			return false;
		}
		if (!checkDuplicateCarName(carNameList)) {
			return false;
		}

		for (String name : carNameList) {
			if (!checkInputIsBlank(name)) {
				return false;
			}
			if (!checkCarNameLength(name)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidAttemptNumber(String attemptNumber) {
		for (int i = 0; i < attemptNumber.length(); i++) {
			char attemptNumberChar = attemptNumber.charAt(i);

			if (!checkInputIsBlank(String.valueOf(attemptNumberChar))) {
				return false;
			}
			if (!checkAttemptNumberIsDigit(attemptNumberChar)) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkDuplicateCarName(List<String> carNameList) {
		HashSet<String> carNameSet = new HashSet<>(carNameList);

		try {
			if (carNameSet.size() == carNameList.size()) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printDuplicateCarName();
			return false;
		}
	}

	public static boolean checkCarNameListSize(List<String> carNameList) {
		try {
			if (carNameList.size() >= CAR_NAME_LIST_MIN_SIZE) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printInvalidCarNameListSize();
			return false;
		}
	}

	public static boolean checkInputIsBlank(String carName) {
		try {
			if (!(carName.isEmpty())) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printInvalidBlankInput();
			return false;
		}
	}

	public static boolean checkCarNameLength(String carName) {
		try {
			if ((carName.length() <= CAR_NAME_MAX_LENGTH)) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printInvalidCarNameLength();
			return false;
		}
	}

	public static boolean checkAttemptNumberIsDigit(char tempInput) {
		try {
			if (Character.isDigit(tempInput)) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printInvalidAttemptNumber();
		}
		return false;
	}

}
