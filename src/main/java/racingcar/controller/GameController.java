package racingcar.controller;

import racingcar.InputValidator;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private int roundNumber;

	public void start() {
		makeCars();
		makeRoundNumber();
		for (int i = 0; i < roundNumber; i++) {
			playRound();
		}
	}

	private void playRound() {
		CarRepository.moveCars();
	}

	private void makeCars() {
		String[] carNames = getCarNameArray();
		CarRepository.clearCars();
		for (String carName : carNames) {
			CarRepository.addCar(new Car(carName));
		}
	}

	private String[] getCarNameArray() {
		OutputView.printCarNameRequestMessage();
		String carNames = InputView.getCarNames();
		try {
			InputValidator.checkIsValidCarNames(carNames);
		} catch (Exception exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getCarNameArray();
		}
		return carNames.split(",");
	}

	private void makeRoundNumber() {
		roundNumber = Integer.parseInt(getRoundNumberInput());
	}

	private String getRoundNumberInput() {
		OutputView.printRoundNumberRequestMessage();
		String roundNumber = InputView.getRoundNumber();
		try {
			InputValidator.checkIsValidRoundNumber(roundNumber);
		} catch (Exception exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getRoundNumberInput();
		}
		return roundNumber;
	}
}
