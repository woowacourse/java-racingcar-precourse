package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.ExceptionUtils;

public class InputView {

	private static final String CAR_NAME_DELIMITER = ",";

	private InputView() {
	}

	public static List<String> writeCarNames() {
		String inputCarNames;
		List<String> carNames;

		OutputView.askCarNames();
		inputCarNames = Console.readLine();
		carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
		try {
			ExceptionUtils.validateCarNames(inputCarNames, carNames);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			carNames = writeCarNames();
		}
		return carNames;
	}

	public static int writeNumberOfAttempts() {
		String inputNumber;
		int numberOfAttempts;

		OutputView.askNumberOfAttempts();
		inputNumber = Console.readLine();
		try {
			ExceptionUtils.validateNumberOfAttempts(inputNumber);
			numberOfAttempts = Integer.parseInt(inputNumber);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			numberOfAttempts = writeNumberOfAttempts();
		}
		return numberOfAttempts;
	}
}
