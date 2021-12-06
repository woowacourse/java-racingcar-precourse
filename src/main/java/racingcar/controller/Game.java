package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.Input;
import racingcar.view.Output;

public class Game {

	static final int INITIAL_ROUND_NUMBER = 0;
	RacingCars racingCars;
	Input input = new Input();
	Output output = new Output();

	public void start() {
		racingCars = new RacingCars(input.requestCarsName());
		int count = input.requestCount();
		run(count);

	}

	private void run(int count) {
		for (int round = INITIAL_ROUND_NUMBER; round < count; round++) {
			racingCars.moveOrStopCars();

		}
	}
}
