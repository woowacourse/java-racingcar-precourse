package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RaceStadium {
	private final Cars cars = new Cars();

	private int trial;
	public void start() {
		cars.join(InputView.getInputRaceCar());
		trial = InputView.getInputTrial();
	}
}
