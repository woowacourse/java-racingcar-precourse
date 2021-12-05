package racingcar.controller;

import static racingcar.constant.GameErrorMessage.*;
import static racingcar.constant.GameMessage.*;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.RacingCars;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
	private final RacingCars racingCars;
	private final int attemptNumber;

	public RacingGameController() {
		racingCars = new RacingCars(getCarNames());
		attemptNumber = getAttemptNumber();
	}

	private static List<String> getCarNames() {
		List<String> inputCarNames;
		do {
			OutputView.printAskingCarNames();
			inputCarNames = toList(InputView.getInput());
		} while (!CarService.isValidCarName(inputCarNames));
		return inputCarNames;
	}

	private static List<String> toList(String carNames) {
		return Arrays.asList(carNames.split(DELIMITER));
	}

	private int getAttemptNumber() {
		try {
			OutputView.printAskingAttemptNumber();
			return Integer.parseInt(InputView.getInput());
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
			return getAttemptNumber();
		}
	}

	public void startGame() {
		OutputView.printExecutionResultMessage();
		playGame();
		printWinner();
	}

	private void playGame() {
		for (int i = 0; i < attemptNumber; i++) {
			racingCars.move();
			printExecutionForEachOrder();
		}
	}

	private void printExecutionForEachOrder() {
		OutputView.printExecutionForEachOrderMessage(racingCars.getExecutionForEachOrderMessage());
	}

	private void printWinner() {
		OutputView.printWinner(racingCars.getWinner());
	}
}
