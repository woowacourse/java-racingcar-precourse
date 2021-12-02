package racingcar.utils;

import java.util.List;

import racingcar.view.OutputView;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public static boolean checkCarNameLength(List<String> carNameList) {
		for (String carName : carNameList) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				OutputView.printInvalidCarName();
				return false;
			}
		}
		return true;
	}

	public static boolean checkAttemptNumber(String tempInput) {
		for (int i = 0; i < tempInput.length(); i++) {
			if (!Character.isDigit(tempInput.charAt(i))) {
				OutputView.printInvalidAttemptNumber();
				return false;
			}
		}
		return true;
	}

}
