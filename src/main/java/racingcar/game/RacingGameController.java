package racingcar.game;

import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
	private RacingGame racingGame;
	private Attempts attempts;

	public RacingGameController(RacingGame racingGame) {
		this.racingGame = racingGame;
	}

	public void run() {
		requestAttempts();
		startRacing();
		announceWinners();
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
		OutputView.showWinners(racingGame.getWinners());
	}
}
