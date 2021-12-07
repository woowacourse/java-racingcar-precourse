package racingcar;

import static racingcar.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	private String[] carsList;
	private int numberOfMove;

	public String[] getCarsList() {
		return carsList;
	}

	public int getNumberOfMove() {
		return numberOfMove;
	}

	public void scanCarsList() {
		boolean carsScan = true;
		System.out.println(CAR_NAME_INPUT);
		while (carsScan) {
			try {
				String carsInput = Console.readLine();
				isValidCars(carsInput);
				carsList = carsInput.split(",");
				isValidCarsList();
				carsScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumberOfMove() {
		boolean numberScan = true;
		System.out.println(TRY_NUMBER);
		while (numberScan) {
			try {
				String numberOfMove = Console.readLine();
				isValidNumber(numberOfMove);
				this.numberOfMove = toInt(numberOfMove);
				numberScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void isValidCars(String carsInput) throws IllegalArgumentException {
		if (carsInput.length() == 0) {
			throw new IllegalArgumentException(CAR_NAME_ERROR);
		}
	}

	public void isValidCarsList() throws IllegalArgumentException {
		if (!checkEmptyList(carsList) || !checkCarNameLength(carsList) || !checkCarsListLength(carsList)) {
			throw new IllegalArgumentException(CAR_NAME_ERROR);
		}
	}

	public boolean checkEmptyList(String[] carsList) {
		if (carsList.length == 0) {
			return false;
		}
		return true;
	}

	public boolean checkCarNameLength(String[] carsList) {
		for (String car : carsList) {
			if (car.length() > MAXIMUM_NAME_LENGTH) {
				return false;
			}
		}
		return true;
	}

	public boolean checkCarsListLength(String[] carsList) {
		if (carsList.length == 1) {
			return false;
		}
		return true;
	}

	public void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0 || !isNumber(number) || number.equals(TRY_NUMBER_ZERO)) {
			throw new IllegalArgumentException(TRY_NUMBER_ERROR);
		}
	}

	public boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit((number.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
