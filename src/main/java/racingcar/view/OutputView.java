package racingcar.view;

import java.util.ArrayList;

import racingcar.Constants;

public class OutputView {

	public static void printPlayMessage() {
		System.out.println(Constants.ROUND_RESULT);
	}

	public static void printRoundResult(ArrayList<String> roundResults) {
		roundResults.forEach(System.out::println);
		System.out.println();
	}

	public static void printWinner(ArrayList<String> winners) {
		System.out.println(Constants.WINNER_RESULT + String.join(Constants.DELIMITER_WINNER, winners));
	}
}
