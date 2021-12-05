package racingcar;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.CarRepository;

public class Game {
	CarRepository carRepository = new CarRepository();

	public void run() {
		setCars();
		int tryNumberOfCarMoving = inputTryNumberOfCarMoving();
		printBlankLine();
		playRacing(tryNumberOfCarMoving);
		printFinalCarWinners(carRepository.getWinnerCarsName());
	}

	private void setCars() {
		carRepository.createCars(inputCarNames());
	}

	private void playRacing(int tryNumberOfCarMoving) {
		System.out.println("실행 결과");
		for (int i = 0; i < tryNumberOfCarMoving; i++) {
			carRepository.attemptCarsMoving();
			printCarsStatus(carRepository.getCarsStatusByFormatter());
		}
	}
}
