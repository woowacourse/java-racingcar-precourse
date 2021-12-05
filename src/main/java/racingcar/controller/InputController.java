package racingcar.controller;

import java.util.stream.Stream;

import racingcar.util.Constant;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class InputController {
	private String[] carNameArray;

	public String[] inputCarName() {
		do {
			generateCarNameArray(InputView.inputCar());
		} while (!validateCarName());
		return carNameArray;
	}

	public int inputAttemptNumber() {
		String attempt;
		do {
			attempt = InputView.inputAttemptNumber();
		} while (!validateAttemptNumber(attempt));
		return Integer.parseInt(attempt);
	}

	private void handleInputError(boolean isCorrect, String errorMessage) {
		try {
			if (!isCorrect) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(errorMessage);
		}
	}

	private void generateCarNameArray(String carData) {
		carNameArray = carData.split(Constant.CAR_NAME_SEPARATOR);
	}

	private boolean validateCarName() {
		boolean isValid = Stream.of(carNameArray)
			.allMatch(name -> InputValidator.isNotEmpty(name) && InputValidator.checkCarNameLength(name));
		handleInputError(isValid, Constant.ERROR_MESSAGE_CAR_NAME);
		return isValid;
	}

	private boolean validateAttemptNumber(String attemptNumber) {
		boolean isValid =
			InputValidator.isNotEmpty(attemptNumber) && InputValidator.checkAttemptIsNumber(attemptNumber);
		handleInputError(isValid, Constant.ERROR_MESSAGE_ATTEMPT_NUMBER);
		return isValid;
	}
}
