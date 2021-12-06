package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameStatus;
import racingcar.domain.RacingCarGame;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
	InputView inputView;
	ResultView resultView;
	ErrorView ErrorView;

	public GameController() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
		this.ErrorView = new ErrorView();
	}

	public void init() {
		String inputCarNames = inputView.getCarNames();
		try {
			Cars cars = Cars.generateCars(inputCarNames);
			RacingCarGame racingCarGame = initRacingCarGame(cars);

			while (!racingCarGame.isGameEnd()) {
				racingCarGame.startRound();
				GameStatus gameStatus = racingCarGame.generateGameStatus();
				resultView.showRoundResult(gameStatus);
			}
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMessage(e.getMessage());
			init();
		}
	}

	public RacingCarGame initRacingCarGame(Cars cars) {
		RacingCarGame racingCarGame;

		String roundNumber = inputView.getRoundNumber();

		try {
			racingCarGame = RacingCarGame.generateGame(roundNumber, cars);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMessage(e.getMessage());
			racingCarGame = initRacingCarGame(cars);
		}

		return racingCarGame;
	}
}
