package racingcar.controller;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
	private final Cars cars;
	private final Round round;

	public RacingGame() {
		this.cars = initCarNames();
		this.round = initRoundNumber();
	}

	public void run() {
		start();
		end();
	}

	private void start() {
		for (int i = 0; i < round.getRound(); i++) {
			OutputView.printNewLine();
			cars.move();
			OutputView.printCarPosition(cars);
		}
	}

	private void end() {
		List<String> winners = cars.findWinners();
		OutputView.printWinners(winners);
	}

	private Cars initCarNames() {
		try {
			String carNames = InputView.inputNames();
			return new Cars(carNames);
		} catch (Exception e) {
			OutputView.printlnMessage(e.getMessage());
			return initCarNames();
		}
	}

	private Round initRoundNumber() {
		try {
			String numberOfRound = InputView.inputRound();
			return new Round(numberOfRound);
		} catch (Exception e) {
			OutputView.printlnMessage(e.getMessage());
			return initRoundNumber();
		}
	}
}
