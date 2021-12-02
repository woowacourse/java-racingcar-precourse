package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import racingcar.domain.Car;
import racingcar.type.GameState;
import racingcar.util.Constant;
import racingcar.util.RandomNumberGenerator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static GameState gameState;
	private String[] carNameArray;
	private final List<Car> cars = new ArrayList<>();
	private int attemptNumber;

	public void init() {
		gameState = GameState.PLAY;
	}

	public void play() {
		inputInitialValue();
		init();
		generateCar();
		startRace();
	}

	private void inputInitialValue() {
		do {
			init();
			validateCarName(InputView.inputCar());
		} while (gameState == GameState.INPUT_ERROR);

		String attempt;
		do {
			init();
			attempt = InputView.inputAttemptNumber();
			validateAttemptNumber(attempt);
		} while (gameState == GameState.INPUT_ERROR);
		attemptNumber = Integer.parseInt(attempt);
	}

	private void handleInputError(boolean isCorrect, String errorMessage) {
		try {
			if (!isCorrect) {
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
		carNameArray = carData.split(Constant.CAR_NAME_SEPARATOR);
		boolean isCorrectLength = Stream.of(carNameArray)
			.allMatch(InputValidator::checkCarNameLength);
		handleInputError(isCorrectLength, Constant.ERROR_MESSAGE_CAR_NAME);
	}

	public void validateAttemptNumber(String attemptNumber) {
		boolean isNumber = InputValidator.checkAttemptIsNumber(attemptNumber);
		handleInputError(isNumber, Constant.ERROR_MESSAGE_ATTEMPT_NUMBER);
	}

	private void generateCar() {
		for (String name : carNameArray) {
			Car car = new Car(name);
			cars.add(car);
		}
	}

	private void startRace() {
		for (int i = 0; i < attemptNumber; i++) {
			cars.stream()
				.peek(car -> car.move(RandomNumberGenerator.generate()))
				.forEach(OutputView::printMoveResult);
			System.out.println();
		}
	}
}
