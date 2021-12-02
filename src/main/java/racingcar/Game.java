package racingcar;

import racingcar.domain.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
	public void run() {
		CarRepository carRepository = new CarRepository();
		carRepository.createCars(InputView.inputCarNames());
		carRepository.attemptCarsMoving();
		OutputView.printCarsStatus(carRepository.getCarList());
		OutputView.printFinalCarWinners(carRepository.getWinnerCars());
	}
}
