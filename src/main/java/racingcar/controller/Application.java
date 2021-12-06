package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import java.util.List;

import racingcar.ValidationUtils;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		Cars winners = runGame(generateCars(), getGameCount());
		printFinalWinner(winners);
	}

	private static Cars generateCars() {
		List<String> userInput;
		do {
			printStartMessage();
			userInput = strToList(generateUserInput());
		} while (!ValidationUtils.validCarList(userInput));
		Cars carList = new Cars(userInput);

		return carList;
	}

	private static int getGameCount() {
		String input;
		do {
			printGetCountMessage();
			input = generateUserInput();
		} while (!ValidationUtils.validNumber(input));
		return Integer.parseInt(input);
	}

	private static Cars runGame(Cars carList, int gameCount) {
		Game newGame = new Game(carList);
		OutputView.printResultMessage();
		for (int i = 0; i < gameCount; i++) {
			newGame.runGameOneStep();
			OutputView.printScoreOfOneStep(newGame.getCarList().getCars());
		}
		return newGame.getCarList();
	}
}
