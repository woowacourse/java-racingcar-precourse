package racingcar.utils;

import java.util.List;

import racingcar.view.OutputView;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public static boolean isValidCarName(List<String> carNameList) {
		if (!checkCarNamesMoreThanTwo(carNameList)) {
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

	public static boolean checkCarNamesMoreThanTwo(List<String> carNameList) {
		try {
			if (carNameList.size() >= 2) {
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
