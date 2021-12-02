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
		do {
			init();
			validateCarName(InputView.inputCar());
			if (gameState == GameState.INPUT_ERROR) {
				continue;
			}
		} while (gameState == GameState.PLAY);

	}

	public void validateCarName(String carData) {
		cars = carData.split(Constant.CAR_NAME_SEPARATOR);
		boolean isCorrectLength = Stream.of(cars)
			.allMatch(name -> InputValidator.checkCarNameLength(name));

		try {
			if (!isCorrectLength) {
				throw new IllegalArgumentException(Constant.ERROR_MESSAGE_CAR_NAME);
			}
		} catch (IllegalArgumentException exception) {
			gameState = GameState.INPUT_ERROR;
		}
	}
}
