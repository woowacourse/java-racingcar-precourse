package racingcar.utils;

import java.util.List;

import racingcar.view.OutputView;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public static boolean checkValid(List<String> carNameList) {
		for (String name : carNameList) {
			if (!checkCarNameLength(name)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkAttemptNumberValid(String attemptNumber) {
		for (int i = 0; i < attemptNumber.length(); i++) {
			if (!checkAttemptNumber(attemptNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}


	public static boolean checkCarNameLength(String carName) {
		try {
			if ((carName.length() <= CAR_NAME_MAX_LENGTH)) {
				return true;
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			OutputView.printInvalidCarName();
			return false;
		}
	}

	public static boolean checkAttemptNumber(char tempInput) {
		try	{
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
