package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class InputUtils {

	private static final String CAR_NAME_DELIMITER = ",";

	private InputUtils() {
	}

	public static List<String> getCarNames(String inputCarNames) {
		List<String> carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
		try {
			ExceptionUtils.validateCarNames(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			OutputView.askCarNames();
			carNames = getCarNames(InputView.writeCarNames());
		}
		return carNames;
	}
}