package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public String[] carsList;
	public int numberOfMove;

	public void scanCarsList() {
		boolean carsScan = true;
		System.out.println(Constant.CAR_NAME_INPUT);
		while (carsScan) {
			try {
				String carsInput = Console.readLine();
				isValidCars(carsInput);
				carsScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumberOfMove() {
		boolean numberScan = true;
		System.out.println(Constant.TRY_NUMBER);
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
			throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
		}
		carsList = carsInput.split(",");
		for (String car : carsList) {
			if (car.length() > Constant.MAXIMUM_NAME_LENGTH) {
				throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
			}
		}
	}

	public void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0) {
			throw new IllegalArgumentException(Constant.TRY_NUMBER_ERROR);
		}
		for (int index = 0; index < number.length(); index++) {
			if (!Character.isDigit((number.charAt(index)))) {
				throw new IllegalArgumentException(Constant.TRY_NUMBER_ERROR);
			}
		}
	}

	public int toInt(String number) {
		return Integer.parseInt(number);
	}
}
