package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;

import racingcar.utils.Constant;

public class OutputView {
	public static void showGameResultMessage() {
		System.out.println();
		System.out.println(Constant.GAME_RESULT_ALARM_MESSAGE);
	}

	public static void showGameRoundResult(LinkedHashMap<String, String> gameRoundResult) {
		for (String carName : gameRoundResult.keySet()) {
			System.out.println(carName + " : " + gameRoundResult.get(carName));
		}
		System.out.println();
	}

	public static void showWinner(List<String> winnerCarNames) {
		StringBuilder sb = new StringBuilder();
		for (String winnerCarName : winnerCarNames) {
			sb.append(winnerCarName).append(", ");
		}
		String winners = sb.substring(0, sb.length() - 2);
		System.out.println(Constant.WINNING_ANNOUNCEMENT_MESSAGE + winners);
	}
}
