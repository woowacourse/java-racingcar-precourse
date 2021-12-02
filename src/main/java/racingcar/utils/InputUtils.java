package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class InputUtils {

	private static final String CAR_NAME_DELIMITER = ",";

	private InputUtils() {
	}

	public static List<String> getCarNames(String inputCarNames) {
		List<String> carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
		try {
			ExceptionUtils.validateCarNames(inputCarNames, carNames);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			carNames = requestCarNames();
		}
		return carNames;
	}

	public static List<String> requestCarNames() {
		OutputView.askCarNames();
		return getCarNames(InputView.writeCarNames());
	}
}
