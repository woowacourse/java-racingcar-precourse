package racingcar;

import racingcar.domain.car.Cars;
import racingcar.processor.InputProcessor;
import racingcar.processor.OutputProcessor;
import racingcar.domain.result.RacingResult;

public class RacingGame {
	private final InputProcessor inputProcessor;
	private final OutputProcessor outputProcessor;

	public RacingGame() {
		inputProcessor = new InputProcessor();
		outputProcessor = new OutputProcessor();
	}

	public void start() {
		Cars cars = null;
		while (cars == null) {
			cars = generateCars();
		}
		RacingResult racingResult = null;
		while (racingResult == null) {
			racingResult = generateRacing(cars);
		}
		runRacing(racingResult);
	}

	private void runRacing(RacingResult racingResult) {
		outputProcessor.printResultBeginning();
		while (!racingResult.isEnd()) {
			racingResult.run();
			outputProcessor.printResult(racingResult);
		}
		outputProcessor.printWinner(racingResult);
	}

	private RacingResult generateRacing(Cars cars) {
		try {
			String count = inputProcessor.readCount();
			return RacingResult.of(count, cars);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Cars generateCars() {
		try {
			String[] names = inputProcessor.readNames();
			return Cars.of(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
