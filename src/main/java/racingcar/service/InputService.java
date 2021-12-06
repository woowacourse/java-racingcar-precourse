package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputService {
	private final static String CAR_NAME_DELIMITER = ",";

	public static List<String> getCarNames() {
		List<String> carNames;
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

	private static List<String> separateCarNames(String names) {
		ValidationService.checkCarNames(names, CAR_NAME_DELIMITER);
		return makeClearCarNames(names.split(CAR_NAME_DELIMITER));
	}

	private static List<String> makeClearCarNames(String[] names) {
		List<String> result = Arrays.stream(names).map(String::trim).collect(Collectors.toList());
		ValidationService.checkDuplicatedCarName(result);
		ValidationService.checkEachCarName(result);
		return result;
	}

}
