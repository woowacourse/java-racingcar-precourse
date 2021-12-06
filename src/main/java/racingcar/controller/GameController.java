package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class GameController {
	InputView inputView;
	ErrorView ErrorView;

	public GameController() {
		this.inputView = new InputView();
		this.ErrorView = new ErrorView();
	}

	public void init() {
		String inputCarNames = inputView.getCarNames();
		try {
			Cars cars = Cars.generateCars(inputCarNames);

			String roundNumber = inputView.getRoundNumber();
			RacingCarGame racingCarGame = RacingCarGame.generateGame(roundNumber, cars);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMessage(e.getMessage());
			init();
		}
	}
}
