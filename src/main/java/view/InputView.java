package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String NAME_DELIMITER = ",";

	private InputView() {
	}

	public static String[] getCarNames() {
		OutputView.printCarNamesInputMessage();
		String[] carNames = Console.readLine().split(NAME_DELIMITER);
		try {
			validateCarName(carNames);
		} catch (Exception exception) {
			OutputView.printCarNameLengthExceptionMessage();
			getCarNames();
		}
		return carNames;
	}

	private static void validateCarName(String[] carNames) {
		for (String car : carNames) {
			if (car.length() >= MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static int getMoveTimes() {
		OutputView.printMoveTimesInputMessage();
		String moveTimes = Console.readLine();
		try {
			validateMoveTimes(moveTimes);
		} catch (Exception exception) {
			OutputView.printMoveTimesExceptionMessage();
			getMoveTimes();
		}
		return Integer.parseInt(moveTimes);
	}

	private static void validateMoveTimes(String moveTimes) {
		try {
			Integer.parseInt(moveTimes);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

	}
}
