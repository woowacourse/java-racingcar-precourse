package racingcar.service;

import java.util.stream.Stream;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputService {
	final static String DELIMITER = ",";

	public static String[] getCarNames() {
		String[] carNames;
		while (true) {
			try {
				carNames = separateCarNames(InputView.scanCarNames());
				break;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
		return carNames;
	}

	public static int getTryNumber() {
		int tryNumber;
		while (true) {
			try {
				String number = InputView.scanTryNumber();
				ValidationService.checkTryNumberIsValid(number);
				tryNumber = Integer.parseInt(number);
				break;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
		return tryNumber;
	}

	private static String[] separateCarNames(String names) {
		ValidationService.checkCarNames(names, DELIMITER);
		return makeClearCarNames(names.split(DELIMITER));
	}

	private static String[] makeClearCarNames(String[] names) {
		String[] result = Stream.of(names).map(String::trim).toArray(String[]::new);
		ValidationService.checkDuplicatedCarName(result);
		ValidationService.checkEachCarName(result);
		return result;
	}

}
