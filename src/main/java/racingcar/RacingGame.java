package racingcar;

import java.util.Arrays;

import racingcar.view.InputView;

public class RacingGame {
	public void startGame() {
		String[] everyCarName = InputView.enterEveryCarName();
		Arrays.stream(everyCarName).forEach(eachCarName -> validateCarName(eachCarName));
		int tryCntAboutCarMoving = InputView.enterTryCnt();
		// for (int i = 0; i < tryCntAboutCarMoving; i++) {
		// 	moveEveryCar(everyCarName);
		// }
		for (String s : everyCarName) {
			System.out.println("s = " + s);
		}
		System.out.println("tryCntAboutCarMoving = " + tryCntAboutCarMoving);
	}

	private static void validateCarName(String eachCarName) { // TODO: 이 로직은 INputView 로 옮기는게 적절할거같음.
		if (eachCarName.length() > 5) {
			throw new IllegalArgumentException("차 이름이 5글자가 넘어감.");
		}
		if (eachCarName.isEmpty()) {
			throw new IllegalArgumentException("차 이름 중 null값 있음");
		}
	}

}
