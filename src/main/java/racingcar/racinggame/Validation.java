package racingcar.racinggame;

public class Validation {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String BLANK_NAME_ERROR = "자동차 이름은 빈칸일 수 없습니다.";

	private static final int MIN_NUMBER_OF_CARS = 1;

	public void isValid(String[] carNames) {
		isEmpty(carNames);
		}

	private void isEmpty(String[] carNames) {
		if (carNames.length < MIN_NUMBER_OF_CARS) {
			throw new IllegalArgumentException(ERROR_MESSAGE + BLANK_NAME_ERROR);
		}
	}
}
