package racingcar.model;

import java.util.Arrays;

public class CarNamesBuilder {
	private static final String CAR_NAMES_SPLIT_REGEX = ",";

	private static String[] carNames;

	private CarNamesBuilder() {}

	public static String[] get(String inputCarNames) {
		split(inputCarNames);
		trim();
		return carNames;
	}

	private static void split(String inputCarNames) {
		carNames = inputCarNames.split(CAR_NAMES_SPLIT_REGEX);
	}

	private static void trim() {
		carNames = Arrays.stream(carNames)
			.map(String::trim)
			.toArray(String[]::new);
	}
}
