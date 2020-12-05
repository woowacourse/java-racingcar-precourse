package utils;

import static utils.Message.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleManager {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private final Scanner scanner;

	public ConsoleManager(Scanner scanner) {
		this.scanner = scanner;
	}

	public String[] getCarNamesForInput() {
		System.out.println(CAR_NAME_INPUT_GUIDE);

		String[] scannedCarNames = scanner.nextLine().split(",");

		validateCarNames(scannedCarNames);

		return scannedCarNames;
	}

	private void validateCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				throw new IllegalArgumentException(CAR_NAME_ERROR);
			}
		}
	}

	public int getMoveNumberFromInput() {
		System.out.println(CAR_MOVE_NUMBER_INPUT_GUIDE);

		int moveNumber = 0;

		try {
			moveNumber = scanner.nextInt();
		} catch (InputMismatchException mismatchException) {
			throw new IllegalArgumentException(CAR_MOVE_NUMBER_ERROR);
		}

		return moveNumber;
	}
}
