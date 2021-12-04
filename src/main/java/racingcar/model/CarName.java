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
		trim();

		validate();

		return carNames;
	}

	private void splitInputCarNamesToCarNames() {
		carNames = inputCarNames.split(CAR_NAMES_SPLIT_REGEX);
	}

	private void trim() {
		carNames = Arrays.stream(carNames)
			.map(String::trim)
			.toArray(String[]::new);
	}

	private void validate() {
		CarNamesValidator carNamesValidator = new CarNamesValidator(carNames);
		carNamesValidator.validate();
	}
}
