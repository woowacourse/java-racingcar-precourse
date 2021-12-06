package view;

import camp.nextstep.edu.missionutils.Console;
import util.CarNameValidator;

public class InputView {

	private static final String NAME_DELIMITER = ",";

	private InputView() {
	}

	public static String[] getCarNames() {
		OutputView.printCarNamesInputMessage();
		String[] carNames = Console.readLine().split(NAME_DELIMITER);
		try {
			CarNameValidator.validate(carNames);
		} catch (Exception exception) {
			OutputView.printCarNameLengthExceptionMessage();
			getCarNames();
		}
		return carNames;
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
