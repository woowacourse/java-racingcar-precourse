package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceStadium {
	private final Cars cars = new Cars();

	private int trial;

	public void start() {
		cars.join(InputView.getInputRaceCar());
		trial = InputView.getInputTrial();
		racing();
		WinnerDto winners = Winner.decision(cars);
		OutputView.printWinner(winners);
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
