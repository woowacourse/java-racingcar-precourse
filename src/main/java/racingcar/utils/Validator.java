package racingcar.utils;

import java.util.HashSet;
import java.util.List;

public class Validator {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final int CAR_NAME_LIST_MIN_SIZE = 2;

	public static boolean isValidCarName(List<String> carNameList) {

		for (String name : carNameList) {
			try {
				checkInputIsBlank(name);
				checkCarNameLength(name);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}

		try {
			checkCarNameListSize(carNameList);
			checkDuplicateCarName(carNameList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean isValidAttemptNumber(String attemptNumber) {

		for (int i = 0; i < attemptNumber.length(); i++) {
			char attemptNumberChar = attemptNumber.charAt(i);

			try {
				checkInputIsBlank(attemptNumber);
				checkAttemptNumberIsDigit(attemptNumberChar);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return true;
	}

	public static void checkDuplicateCarName(List<String> carNameList) {
		HashSet<String> carNameSet = new HashSet<>(carNameList);
		if (carNameSet.size() == carNameList.size()) {
			return;
		}
		throw new IllegalArgumentException(Message.ERROR_DUPLICATE_CAR_NAME.getMessage());
	}

	public static void checkCarNameListSize(List<String> carNameList) {
		if (carNameList.size() >= CAR_NAME_LIST_MIN_SIZE) {
			return;
		}
		throw new IllegalArgumentException(Message.ERROR_CAR_NAME_LIST_SIZE.getMessage());
	}

	public static void checkCarNameLength(String carName) {
		if ((carName.length() <= CAR_NAME_MAX_LENGTH)) {
			return;
		}
		throw new IllegalArgumentException(Message.ERROR_INVALID_CAR_NAME_LENGTH.getMessage());
	}

	public static void checkInputIsBlank(String carName) {
		if (!(carName.isEmpty())) {
			return;
		}
		throw new IllegalArgumentException(Message.ERROR_INPUT_IS_BLANK.getMessage());
	}

	public static void checkAttemptNumberIsDigit(char tempInput) {
		if (Character.isDigit(tempInput)) {
			return;
		}
		throw new IllegalArgumentException(Message.ERROR_INVALID_ATTEMPT_NUMBER.getMessage());
	}

}
