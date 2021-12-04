package racingcar.controller;

import racingcar.service.InputService;
import racingcar.service.RacingService;

public class RacingController {

	private RacingService racingService = new RacingService();
	private InputService inputService = new InputService();

	private static final String RESULT = "실행결과";

	public void start() {
		String[] names = inputService.readCarNames();
		racingService.registerCars(names);

		int attempt = inputService.readAttemptNumber();

		System.out.println();
		System.out.println(RESULT);

		for (int i = 0; i < attempt; i++) {
			racingService.race();
			racingService.showRaceProgress();
		}

		racingService.showWinnersName();
	}
}
