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

			startGame(racingCarGame);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMessage(e.getMessage());
			init();
		}
	}

	private void startGame(RacingCarGame racingCarGame) {
		resultView.showResultHeader();
		while (!racingCarGame.isGameEnd()) {
			racingCarGame.startRound();
			GameStatus gameStatus = racingCarGame.generateGameStatus();
			resultView.showRoundResult(gameStatus);

			if (racingCarGame.isGameEnd()) {
				resultView.showWinners(gameStatus.getWinnerNames());
			}
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
