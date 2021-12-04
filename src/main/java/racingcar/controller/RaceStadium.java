package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceStadium {
	private final Cars cars = new Cars();

	private int trial;

	public void start() {
		cars.join(InputView.getInputRaceCar());
		trial = InputView.getInputTrial();
		racing();
		List<String> winnerNames = Winner.decision(cars);
		OutputView.printWinner(winnerNames);
	}

	private void racing() {
		OutputView.printGameStartMessage();
		for (int round = 0; round < trial; round++) {
			moveTry();
			OutputView.printRacingCurrentSituation(cars);
		}
	}

	private void moveTry() {
		for (Car participant : cars.getCars()) {
			participant.moveOrStop();
		}
	}
}
