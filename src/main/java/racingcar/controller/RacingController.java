package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.utils.InputTryCountValidator;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;
	private String inputCarNames;
	private String[] carNames;
	private List<Car> carList;
	private String inputTryCount;
	private int tryCount;

	public RacingController() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void startRacing() {
		getCarNames();
		getTryCount();
		createCars();

		outputView.printResultMessage();
		for (int i = 0; i < tryCount; i++) {
			moveCars();
			outputView.printResult(carList);
		}

		Winner winner = new Winner(carList);
		String[] winners = winner.getWinners();
		outputView.printWinners(winners);
	}

	private void getCarNames() {
		do {
			inputCarNames = inputView.getInputCarNames();
		} while (!handleGetCarNamesException());
	}

	private boolean handleGetCarNamesException() {
		try {
			CarName carName = new CarName(inputCarNames);
			carNames = carName.getCarNames();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void getTryCount() {
		do {
			inputTryCount = inputView.getInputTryCount();
		} while (!handleGetTryCountException());

		tryCount = Integer.parseInt(inputTryCount);
	}

	private boolean handleGetTryCountException() {
		try {
			InputTryCountValidator inputTryCountValidator = new InputTryCountValidator(inputTryCount);
			inputTryCountValidator.validate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void createCars() {
		carList = new ArrayList<>();
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	private void moveCars() {
		for (Car car : carList) {
			car.moveForward();
		}
	}
}
