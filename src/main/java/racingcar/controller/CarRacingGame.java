package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGame {
	private Cars cars;
	private TryCount tryCount;

	public void powerOn() {
		init();
		start();
	}

	private void init() {
		cars = createCars();
		tryCount = readTryCount();
	}

	private void start() {
		printResultMessage();
		while (canPlay()) {
			play();
		}
		printWinners();
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

	private void printResultMessage() {
		OutputView.printResultMessage();
	}

	private boolean canPlay() {
		return tryCount.canTry();
	}

	private void play() {
		useOneTry();
		moveRandomCars();
		printCurrentRoundCars();
	}

	private void useOneTry() {
		tryCount.use();
	}

	private void moveRandomCars() {
		cars.moveOrStop();
	}

	private void printCurrentRoundCars() {
		OutputView.printCars(cars.getCars());
	}

	private void printWinners() {
		List<Car> winners = cars.getRacingWinners();
		OutputView.printRacingWinners(winners);
	}
}
