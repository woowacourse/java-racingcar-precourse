package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarGameController {
	private Cars cars;
	private int racingRound = 0;

	public RacingCarGameController() {
	}

	public void play() {
		cars = new Cars(readCarNames());
		racingRound = readRacingRound();
		System.out.println();

		printStartRoundMessage();
		for (int i = 0; i < racingRound; i++) {
			cars.racing();
		}

		List<Car> winners = cars.findWinners();
		printWinners(winners);
	}
}
