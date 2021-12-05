package racingcar.controller;

import static racingcar.constant.GameMessage.*;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.AttemptNumber;
import racingcar.domain.RacingCars;
import racingcar.service.AttemptNumberService;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
	private final RacingCars racingCars;
	private final AttemptNumber attemptNumber;

	public RacingGameController() {
		racingCars = new RacingCars(getCarNames());
		attemptNumber = new AttemptNumber(getAttemptNumber());
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
		String attemptNumber;
		do {
			OutputView.printAskingAttemptNumber();
			attemptNumber = InputView.getInput();
		} while (!AttemptNumberService.isValidAttemptNumber(attemptNumber));
		return Integer.parseInt(attemptNumber);
	}

	public void startGame() {
		OutputView.printExecutionResultMessage();
		playGame();
		printWinner();
	}

	private void playGame() {
		while (attemptNumber.isAttemptRemained()) {
			racingCars.move();
			printExecutionForEachOrder();
		}
	}

	private void printExecutionForEachOrder() {
		String executionForEachOrderMessage = racingCars.getExecutionForEachOrderMessage();
		OutputView.printExecutionForEachOrderMessage(executionForEachOrderMessage);
	}

	private void printWinner() {
		OutputView.printWinner(racingCars.getWinner());
	}
}
