package racingcar.view;

import java.util.List;

public class OutputView {
	private static final String RACE_RESULT = "실행 결과";

	public static void resultMessage() {
		showSpaceBetweenMessage();
		System.out.println(RACE_RESULT);
	}

	public static void moveResultMessage(List<String> moveResult) {
		for (String each : moveResult) {
			System.out.println(each);
		}
		showSpaceBetweenMessage();
	}

	private static void showSpaceBetweenMessage() {
		System.out.println();
	}

	public static void showWinner(String winner) {
		System.out.println(winner);
	}
}
