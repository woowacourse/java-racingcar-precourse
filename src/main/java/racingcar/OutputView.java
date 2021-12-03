package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
	public static void showGameResultMessage() {
		System.out.println();
		System.out.println(Constant.GAME_RESULT_ALARM_MESSAGE);
	}

	public static void showGameRoundResult(LinkedHashMap<Car, String> gameRoundResult) {
		for (Car car : gameRoundResult.keySet()) {
			System.out.println(car.getName() + " : " + gameRoundResult.get(car));
		}
		System.out.println();
	}

	public static void showWinner(List<Car> winnerCars) {
		StringBuilder sb = new StringBuilder();
		for (Car winnerCar : winnerCars) {
			sb.append(winnerCar.getName()).append(", ");
		}
		String winners = sb.substring(0, sb.length()-2);
		System.out.println(Constant.WINNING_ANNOUNCEMENT_MESSAGE + winners);
	}
}
