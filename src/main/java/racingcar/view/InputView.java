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
		OutputView.askCarNames();
		String inputCarNames = Console.readLine();
		List<String> carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
		try {
			ExceptionUtils.validateCarNames(inputCarNames, carNames);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			carNames = writeCarNames();
		}
		return carNames;
	}

	public static int writeNumberOfAttempts() {
		OutputView.askNumberOfAttempts();
		String inputNumber = Console.readLine();
		int numberOfAttempts;
		try {
			numberOfAttempts = ExceptionUtils.validateNumberOfAttempts(inputNumber);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			numberOfAttempts = writeNumberOfAttempts();
		}
		return numberOfAttempts;
	}
}
