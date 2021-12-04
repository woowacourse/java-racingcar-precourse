package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.CarNamesBuilder;
import racingcar.model.Validator;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	private String[] carNames;
	private List<Car> cars;
	private int tryCount;

	public RacingController() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void readyRacing() {
		getCarNames();
		getTryCount();
		createCars();
	}

	private void getCarNames() {
		do {
			final String inputCarNames = inputView.getInputCarNames();
			carNames = CarNamesBuilder.get(inputCarNames);
		} while (!Validator.isCarNamesValidated(carNames));
	}

	private void getTryCount() {
		String inputTryCount;
		do {
			inputTryCount = inputView.getInputTryCount();
		} while (!Validator.isTryCountValidated(inputTryCount));

		tryCount = Integer.parseInt(inputTryCount);
	}

	private void createCars() {
		cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void startRacing() {
		outputView.printResultMessage();
		repeatRacing();

		getWinners();
	}

	private void repeatRacing() {
		for (int i = 0; i < tryCount; i++) {
			moveCars();
			outputView.printResult(cars);
		}
	}

	private void moveCars() {
		for (Car car : cars) {
			car.moveForward();
		}
	}

	private void getWinners() {
		final Winner winner = new Winner(cars);
		String[] winners = winner.get();
		outputView.printWinners(winners);
	}
}
