package racingcar.game;

import racingcar.attempts.Attempts;
import racingcar.car.CarCarrier;
import racingcar.view.OutputView;

public class RacingGameController {
	private RacingGame racingGame;
	private Attempts attempts;

	public RacingGameController(CarCarrier carCarrier, Attempts attempts) {
		this.racingGame = new RacingGame(carCarrier.getCars());
		this.attempts = attempts;
	}

	public void play() {
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
