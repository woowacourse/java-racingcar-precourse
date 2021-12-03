package racingcar.game;

import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private Cars cars;

	public void run() {
		createCars();
		Attempts attempts = new Attempts();
		inputAttempts(attempts);
		moveCars(cars, attempts);
		Winners winners = new Winners(cars);
		OutputView.showWinner(winners.getWinners());
	}

	private void createCars() {
		CarNames carNames = new CarNames();
		inputCarName(carNames);
		cars = new Cars(carNames.generateCar());
	}

	private void inputCarName(CarNames carNames) {
		InputView.startMessage();
		try {
			carNames.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputCarName(carNames);
		}
	}

	private void inputAttempts(Attempts attempts) {
		InputView.attemptsMessage();
		try {
			attempts.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputAttempts(attempts);
		}
	}

	private void moveCars(Cars cars, Attempts attempts) {
		OutputView.resultMessage();
		do {
			OutputView.moveResultMessage(cars.move());
			attempts.decrease();
		} while (attempts.isLeft());
	}
}
