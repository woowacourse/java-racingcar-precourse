package racingcar;

import static racingcar.Constant.*;

public class InputValidator {
	public static void isValidCarsInput(String carsInput) throws IllegalArgumentException {
		if (carsInput.length() == 0) {
			throw new IllegalArgumentException(CAR_NAME_ERROR);
		}
	}

	public static void isValidCarsList(String[] carsList) throws IllegalArgumentException {
		if (!checkCarNameLength(carsList) || !checkCarsListLength(carsList)) {
			throw new IllegalArgumentException(CAR_NAME_ERROR);
		}
	}

	public static boolean checkCarNameLength(String[] carsList) {
		for (String car : carsList) {
			if (car.length() > MAXIMUM_NAME_LENGTH) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkCarsListLength(String[] carsList) {
		if (carsList.length <= 1) {
			return false;
		}
		return true;
	}

	public static void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0 || !isNumber(number) || number.equals(TRY_NUMBER_ZERO)) {
			throw new IllegalArgumentException(TRY_NUMBER_ERROR);
		}
	}

	public static boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit((number.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
}
