package racingcar;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
	private static final String DELIMITER = ",";

	public static List<String> generateNames(String carNames) {
		NameValidation.isValidateNames(carNames);
		return splitNames(carNames);
	}

	private static List<String> splitNames(String carNames) {
		List<String> names = Arrays.asList(carNames.split(DELIMITER));
		NameValidation.isDuplicated(names);
		return names;
	}
}
