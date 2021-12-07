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
				InputValidator.isValidCarsInput(carsInput);
				carsList = carsInput.split(",");
				InputValidator.isValidCarsList(carsList);
				carsScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumberOfMove() {
		boolean numberScan = true;
		System.out.println(TRY_NUMBER_INPUT);
		while (numberScan) {
			try {
				String numberOfMove = Console.readLine();
				InputValidator.isValidNumber(numberOfMove);
				this.numberOfMove = toInt(numberOfMove);
				numberScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
