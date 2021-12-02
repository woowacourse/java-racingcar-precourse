package racingcar;

import racingcar.view.InputView;

public class RacingGame {
	private EveryCar everyCar;
	private int tryCntAboutCarMoving;

	public void run() {
		initializeRace();
		playGame();
	}

	private void playGame() {
		System.out.println("\n실행 결과");
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
