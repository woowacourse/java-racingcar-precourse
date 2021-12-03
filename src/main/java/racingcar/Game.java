package racingcar;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.CarRepository;

public class Game {
	public void run() {
		CarRepository carRepository = new CarRepository();
		carRepository.createCars(inputCarNames());
		int numberOfCarMoving = inputNumberOfCarMoving();
		for (int i = 0; i < numberOfCarMoving; i++) {
			carRepository.attemptCarsMoving();
			printCarsStatus(carRepository);
		}
		printFinalCarWinners(carRepository);
	}
}
