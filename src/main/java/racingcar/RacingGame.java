package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import racingcar.view.InputView;

public class RacingGame {
	private ArrayList<Car> cars = new ArrayList<>();
	private EveryCar everyCar;

	public void startGame() {
		String[] everyCarName = InputView.enterEveryCarName();
		makeEveryCarInstance(everyCarName);
		everyCar = new EveryCar(cars);
		int tryCntAboutCarMoving = InputView.enterTryCnt();
		System.out.println("\n실행 결과");
		for (int i = 0; i < tryCntAboutCarMoving; i++) {
			everyCar.moveEveryCarThisTiming();
		}
		everyCar.showThisGameWinner();
	}

	private void makeEveryCarInstance(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> cars.add(new Car(eachCarName)));
	}


}
