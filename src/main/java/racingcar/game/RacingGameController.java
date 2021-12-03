package racingcar.game;

import racingcar.car.CarFactory;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
	private RacingGame racingGame;
	private Attempts attempts;

	public void run() {
		createCars();
		requestAttempts();
		startRacing();
		announceWinners();
	}

	private void createCars() {
		InputView.showCarNamesMessage();
		CarFactory carFactory = new CarFactory();
		requestCarNames(carFactory);
		racingGame = new RacingGame(carFactory.generateCars());
	}

	private void requestCarNames(CarFactory carFactory) {
		try {
			carFactory.inputNames();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			requestCarNames(carFactory);
		}
	}

	private void requestAttempts() {
		attempts = new Attempts();
		InputView.showAttemptsMessage();
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
			OutputView.showMoveResult(racingGame.race());
			attempts.decrease();
		} while (attempts.isLeft());
	}

	private void announceWinners() {
		Winners winners = new Winners(racingGame);
		OutputView.showWinners(winners.getWinners());
	}
}
