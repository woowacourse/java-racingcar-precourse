package racingcar;

import static racingcar.view.InputView.*;

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
		participateEveryCar();
		tryCntAboutCarMoving = InputView.enterTryCnt();
	}

	private void participateEveryCar() {
		try {
			String[] everyCarName = StringUtil.splitUsingComma(InputView.enterEveryCarName());
			CarNameValidator.validateEveryCarName(everyCarName);
			everyCar = new EveryCar(everyCarName);
		} catch (IllegalArgumentException e) {
			System.out.println(String.format(SHOW_ERROR_MESSAGE, e.getMessage()));
			participateEveryCar();
		}
	}
}
