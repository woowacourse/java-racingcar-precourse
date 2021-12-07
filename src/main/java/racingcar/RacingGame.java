package racingcar;

import java.util.Optional;

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
		Cars cars = generateCars();
		RacingResult racingResult = generateRacingResult(cars);
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

	private RacingResult generateRacingResult(Cars cars) {
		Optional<String> count = Optional.empty();
		while (!count.isPresent()) {
			count = readCount();
		}
		return RacingResult.of(count.get(), cars);
	}

	private Optional<String> readCount() {
		try {
			String count = inputProcessor.readCount();
			return Optional.of(count);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return Optional.empty();
		}
	}

	private Cars generateCars() {
		Optional<Cars> cars = Optional.empty();
		while (!cars.isPresent()) {
			cars = readCars();
		}
		return cars.get();
	}

	private Optional<Cars> readCars() {
		try {
			String[] names = inputProcessor.readNames();
			return Optional.of(Cars.of(names));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return Optional.empty();
		}
	}

}
