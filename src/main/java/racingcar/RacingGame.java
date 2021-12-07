package racingcar;

import java.util.List;

import racingcar.processor.InputProcessor;
import racingcar.processor.OutputProcessor;
import racingcar.result.Racing;

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
		Racing racing = null;
		while (racing == null) {
			racing = generateRacing(cars);
		}
		runRacing(racing);
	}

	private void runRacing(Racing racing) {
		outputProcessor.printResultBeginning();
		while(!racing.isEnd()) {
			racing.start();
			outputProcessor.printResult(racing);
		}
		outputProcessor.printWinner(racing);
	}

	private Racing generateRacing(Cars cars) {
		try {
			String count = inputProcessor.readCount();
			return Racing.of(count, cars);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Cars generateCars() {
		try {
			List<String> names = inputProcessor.readNames();
			return Cars.of(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
