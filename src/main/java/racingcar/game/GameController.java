package racingcar.game;

import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private Cars cars;
	private Attempts attempts;

	public void run() {
		createCars();
		requestAttempts();
		startRacing();
		Winners winners = new Winners(cars);
		OutputView.showWinner(winners.getWinners());
	}

	private void createCars() {
		InputView.carNamesMessage();
		CarNames carNames = new CarNames();
		inputCarName(carNames);
		cars = new Cars(carNames.generateCar());
	}

	private void inputCarName(CarNames carNames) {
		try {
			carNames.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputCarName(carNames);
		}
	}

	private void requestAttempts() {
		attempts = new Attempts();
		InputView.attemptsMessage();
		inputAttempts(attempts);
	}

	private void inputAttempts(Attempts attempts) {
		try {
			attempts.input();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputAttempts(attempts);
		}
	}

	private void startRacing() {
		OutputView.showResultMessage();
		do {
			OutputView.showMoveResult(cars.race());
			attempts.decrease();
		} while (attempts.isLeft());
	}
}
