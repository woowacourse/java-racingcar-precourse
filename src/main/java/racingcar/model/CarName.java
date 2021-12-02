package racingcar.model;

import java.util.Arrays;

import racingcar.utils.CarNamesValidator;

public class CarName {
	private static final String CAR_NAMES_SPLIT_REGEX = ",";

	private final String inputCarNames;
	private String[] carNames;

	public CarName(String inputCarNames) {
		this.inputCarNames = inputCarNames;
	}

	public String[] getCarNames() {
		splitInputCarNamesToCarNames();
		trimCarNames();

		validateCarNames();

		return carNames;
	}

	private void splitInputCarNamesToCarNames() {
		carNames = inputCarNames.split(CAR_NAMES_SPLIT_REGEX);
	}

	private void trimCarNames() {
		carNames = Arrays.stream(carNames)
			.map(String::trim)
			.toArray(String[]::new);
	}

	private void validateCarNames() {
		CarNamesValidator carNamesValidator = new CarNamesValidator(carNames);
		carNamesValidator.validateCarNames();
	}
}
