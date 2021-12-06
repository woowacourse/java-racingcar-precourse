package racingcar.domain;

import static racingcar.Constant.*;
import static racingcar.view.InputView.*;

import racingcar.StringUtil;
import racingcar.Validator;
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
		moveCarGivenNumber(tryCntAboutCarMoving);
		everyCar.showThisGameWinner();
	}

	private void moveCarGivenNumber(int repeatCnt) {
		OutputView.showSentenceBeforeResult();
		for (int i = 0; i < repeatCnt; i++) {
			everyCar.moveEveryCarThisTiming();
		}
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
