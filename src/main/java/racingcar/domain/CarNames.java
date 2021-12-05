package racingcar.domain;

import java.util.Arrays;

public class CarNames {
	private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 자동차 이름이 있습니다.";

	private final String[] carNames;

	public CarNames(String[] carNames) {
		validateDuplication(carNames);
		this.carNames = Arrays.stream(carNames)
			.map(name -> new CarName(name).get())
			.toArray(String[]::new);
	}

	public String[] get() {
		return carNames;
	}

	private void validateDuplication(String[] carNames) {
		long distinctCount = Arrays.stream(carNames).distinct().count();
		if (carNames.length != distinctCount) {
			throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
		}
	}
}
