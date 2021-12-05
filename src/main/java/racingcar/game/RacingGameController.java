package racingcar.game;

import racingcar.attempts.Attempts;
import racingcar.view.OutputView;

public class RacingGameController {
	private RacingGame racingGame;
	private Attempts attempts;

	public RacingGameController(RacingGame racingGame, Attempts attempts) {
		this.racingGame = racingGame;
		this.attempts = attempts;
	}

	public void run() {
		startRacing();
		announceWinners();
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
