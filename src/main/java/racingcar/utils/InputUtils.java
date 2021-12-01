package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputUtils {

	private static final String CAR_NAME_DELIMITER = ",";

	private InputUtils() {
	}

	public static List<String> getCarNames(String carNames) {
		return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
	}
}
