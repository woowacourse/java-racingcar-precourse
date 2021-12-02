package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
	private EveryCar everyCar;
	private int tryCntAboutCarMoving;

	public void run() {
		initializeRace();
		playGame();
	}

	private void playGame() {
		OutputView.showSentenceBeforeResult();
		for (int i = 0; i < tryCntAboutCarMoving; i++) {
			everyCar.moveEveryCarThisTiming();
		}
		everyCar.showThisGameWinner();
	}

	private void initializeRace() {
		String[] everyCarName = InputView.enterEveryCarName();
		everyCar = new EveryCar(everyCarName);
		tryCntAboutCarMoving = InputView.enterTryCnt();
	}
}
