package utils;

import static utils.Message.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private final Scanner scanner;

	public InputManager(Scanner scanner) {
		this.scanner = scanner;
	}

	public String[] getCarNamesFromInput() {
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

	public int getRoundNumberFromInput() {
		System.out.println(CAR_ROUND_NUMBER_INPUT_GUIDE);

		int roundNumber = 0;

		try {
			roundNumber = scanner.nextInt();
		} catch (InputMismatchException mismatchException) {
			throw new IllegalArgumentException(CAR_ROUND_NUMBER_ERROR);
		}

		return roundNumber;
	}
}
