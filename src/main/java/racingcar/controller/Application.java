package racingcar.controller;

import racingcar.domain.CarRacingGame;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

	public static final String SPLIT_REGEX = ",";

	public static void main(String[] args) {
		Cars cars = InputView.inputCarsName(SPLIT_REGEX);
		CarRacingGame carRacingGame = new CarRacingGame(InputView.inputMovesNumber());
		Rounds rounds = new Rounds();

		while (carRacingGame.checkOneMoreRoundPossible()) {
			cars.move();
			rounds.add(new Round(cars.getRoundResult()));
		}

		ResultView.printResultsByRound(rounds.getRoundResult());
		ResultView.printWinners(rounds.getWinner());
	}
}
