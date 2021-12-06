package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.Input;
import racingcar.view.Output;

public class Game {

	static final int INITIAL_ROUND_NUMBER = 0;
	private static final String RESULT_MASSAGE = "실행 결과";

	RacingCars racingCars;
	Input input = new Input();
	Output output = new Output();

	public void start() {
		racingCars = new RacingCars(input.requestCarsName());
		int count = input.requestCount();
		run(count);

	}

	private void run(int count) {
		System.out.println(RESULT_MASSAGE);
		for (int round = INITIAL_ROUND_NUMBER; round < count; round++) {
			racingCars.moveOrStopCars();
			output.reportThisRoundResult(racingCars);
		}
	}
}
