package racingcar.controller;

import racingcar.InputValidator;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static final String CAR_NAME_SPLITTER = ",";

	private int roundNumber;

	public void start() {
		makeCars();
		makeRoundNumber();
		playRound();
		showGameResult();
	}

	private void playRound() {
		OutputView.printPlayResultMessage();
		for (int i = 0; i < roundNumber; i++) {
			CarRepository.moveCars();
			showPlayResult();
		}
	}

	private void makeCars() {
		String[] carNames = getCarNameArrayFromInput();
		for (String carName : carNames) {
			CarRepository.addCar(new Car(carName));
		}
	}

	private String[] getCarNameArrayFromInput() {
		OutputView.printCarNameRequestMessage();
		String[] carNames = InputView.getCarNames().split(CAR_NAME_SPLITTER);
		try {
			InputValidator.checkIsValidCarNames(carNames);
		} catch (Exception exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getCarNameArrayFromInput();
		}
		return carNames;
	}

	private void makeRoundNumber() {
		roundNumber = getRoundNumberFromInput();
	}

	private int getRoundNumberFromInput() {
		OutputView.printRoundNumberRequestMessage();
		String roundNumber = InputView.getRoundNumber();
		try {
			InputValidator.checkIsValidRoundNumber(roundNumber);
		} catch (Exception exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return getRoundNumberFromInput();
		}
		return Integer.parseInt(roundNumber);
	}

	private void showPlayResult() {
		for (Car car : CarRepository.getCars()) {
			OutputView.printCarInfo(car.toString());
		}
		OutputView.printEmptyLine();
	}

	private void showGameResult() {
		OutputView.printWinners(CarRepository.findCarNameListByWinner());
	}
}
