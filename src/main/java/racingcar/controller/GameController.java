package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView input;
	private final OutputView output;

	public GameController() {
		input = new InputView();
		output = new OutputView();
	}

	public void start() {
		Cars cars = new Cars(input.carNames());
		String round = input.round();

		output.printResultMessage();
		runRound(round, cars);
		output.printChampionList(cars.getChampionList());
	}

	private void runRound(String round, Cars cars) {
		for (int i = 0; i < Integer.parseInt(round); i++) {
			output.printRoundResult(cars.getRoundResult());
		}
	}
}
