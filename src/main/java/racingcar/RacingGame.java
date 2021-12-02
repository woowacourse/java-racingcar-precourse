package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.view.InputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>();
	private EveryCar everyCar;

	public void startGame() {
		String[] everyCarName = InputView.enterEveryCarName();
		everyCar = new EveryCar(everyCarName);
		int tryCntAboutCarMoving = InputView.enterTryCnt();
		System.out.println("\n실행 결과");
		for (int i = 0; i < tryCntAboutCarMoving; i++) {
			everyCar.moveEveryCarThisTiming();
		}
		everyCar.showThisGameWinner();
	}




}
