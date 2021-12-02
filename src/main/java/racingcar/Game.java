package racingcar;

import static racingcar.view.InputView.*;

import racingcar.domain.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
	public void run() {
		CarRepository carRepository = new CarRepository();
		carRepository.createCars(InputView.inputCarNames());
		int numberOfCarMoving =  inputNumberOfCarMoving();
		for (int i = 0; i < numberOfCarMoving; i++) {
			carRepository.attemptCarsMoving();
			OutputView.printCarsStatus(carRepository.getCarList());
		}
		OutputView.printFinalCarWinners(carRepository.getWinnerCars());
	}
}
