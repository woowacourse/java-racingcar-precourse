package racingcar.controller;

import java.util.stream.Stream;

import racingcar.type.GameState;
import racingcar.util.Constant;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class GameController {
	private String[] cars;
	private static GameState gameState;

	public void init() {
		gameState = GameState.PLAY;
	}

	public void play() {
		inputInitialValue();
		init();
	}

	private void inputInitialValue() {
		do {
			init();
			validateCarName(InputView.inputCar());
		} while (gameState == GameState.INPUT_ERROR);

		do {
			init();
			validateAttemptNumber(InputView.inputAttemptNumber());
		} while (gameState == GameState.INPUT_ERROR);
	}

	private void handleInputError(boolean isCorrectLength, String errorMessage) {
		try {
			if (!isCorrectLength) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(errorMessage);
			gameState = GameState.INPUT_ERROR;
			return;
		}
		init();
	}

	public void validateCarName(String carData) {
		cars = carData.split(Constant.CAR_NAME_SEPARATOR);
		boolean isCorrectLength = Stream.of(cars)
			.allMatch(InputValidator::checkCarNameLength);
		handleInputError(isCorrectLength, Constant.ERROR_MESSAGE_CAR_NAME);
	}

	public void validateAttemptNumber(String attemptNumber) {
		boolean isNumber = InputValidator.checkAttemptIsNumber(attemptNumber);
		handleInputError(isNumber, Constant.ERROR_MESSAGE_ATTEMPT_NUMBER);
	}
}
