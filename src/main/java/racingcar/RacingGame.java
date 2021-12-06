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
		determineTryCnt();
	}

	private void determineTryCnt() {
		try {
			tryCntAboutCarMoving = Validator.validateTryCnt(enterTryCnt());
		} catch (IllegalArgumentException e) {
			System.out.println(String.format(SHOW_ERROR_MESSAGE, e.getMessage()));
			determineTryCnt();
		}
	}

	private void participateEveryCar() {
		try {
			String[] everyCarName = StringUtil.splitUsingComma(InputView.enterEveryCarName());
			Validator.validateEveryCarName(everyCarName);
			everyCar = new EveryCar(everyCarName);
		} catch (IllegalArgumentException e) {
			System.out.println(String.format(SHOW_ERROR_MESSAGE, e.getMessage()));
			participateEveryCar();
		}
	}
}
