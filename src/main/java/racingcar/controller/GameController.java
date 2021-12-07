package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RoundStatus;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
	public void init() {
		String inputCarNames = InputView.getCarNames();
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
		ResultView.showResultHeader();
		while (!racingCarGame.isGameEnd()) {
			racingCarGame.startRound();
			RoundStatus roundStatus = racingCarGame.generateRoundStatus();
			ResultView.showRoundResult(roundStatus);

			if (racingCarGame.isGameEnd()) {
				ResultView.showWinners(roundStatus.getWinnerNames());
			}
		}
	}

	public RacingCarGame initRacingCarGame(Cars cars) {
		RacingCarGame racingCarGame;

		String roundNumber = InputView.getRoundNumber();

		try {
			racingCarGame = RacingCarGame.generateGame(roundNumber, cars);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMessage(e.getMessage());
			racingCarGame = initRacingCarGame(cars);
		}

		return racingCarGame;
	}
}
