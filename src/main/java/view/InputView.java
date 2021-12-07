package view;

import camp.nextstep.edu.missionutils.Console;
import util.CarNameValidator;
import util.MoveTimesValidator;

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
			getCarNames();
		}
		return carNames;
	}

	public static int getMoveTimes() {
		OutputView.printMoveTimesInputMessage();
		String moveTimes = Console.readLine();
		try {
			MoveTimesValidator.validate(moveTimes);
		} catch (Exception exception) {
			getMoveTimes();
		}
		return Integer.parseInt(moveTimes);
	}
}
