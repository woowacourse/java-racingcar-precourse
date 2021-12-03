package racingcar;

import java.util.LinkedHashMap;

public class OutputView {
	public static void showGameResultMessage() {
		System.out.println(Constant.GAME_RESULT_ALARM_MESSAGE);
	}

	public static void showGameRoundResult(LinkedHashMap<Car, String> gameRoundResult) {
		for (Car car : gameRoundResult.keySet()) {
			System.out.println(car.getName() + " : " + gameRoundResult.get(car));
		}
		System.out.println();
	}
}
