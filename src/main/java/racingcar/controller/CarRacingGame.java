package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.TryCount;

public class CarRacingGame {
	private Cars cars;
	private TryCount tryCount;

	public void powerOn() {
		cars = createCars();
		tryCount = readTryCount();

		start();
	}

	private void start() {
		OutputView.printResultMessage();
		while (canPlay()) {
			play();
		}
		printWinners();
	}

	private boolean canPlay() {
		return tryCount.canTry();
	}

	private void play() {
		useOneTry();
		cars.moveOrStop();
		OutputView.printCars(cars.getCars());
	}

	private void useOneTry() {
		tryCount.use();
	}

	private void printWinners() {
		List<Car> winners = cars.getRacingWinners();
		OutputView.printRacingWinners(winners);
	}

	private Cars createCars() {
		try {
			return getCarsByInputNames();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return createCars();
		}
	}

	private Cars getCarsByInputNames() {
		List<String> carNames = InputView.readCarNames();
		return Cars.createCarsByNames(carNames);
	}

	private TryCount readTryCount() {
		try {
			return getTryCountByInputNum();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return readTryCount();
		}
	}

	private TryCount getTryCountByInputNum() {
		int tryCount = InputView.readTryCount();
		return new TryCount(tryCount);
	}
}
