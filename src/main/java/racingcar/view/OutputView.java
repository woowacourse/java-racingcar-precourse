package racingcar.view;

import racingcar.type.DelimiterType;
import racingcar.type.TextType;

public class OutputView {

	public static void printfMessage(String message, Object... args) {
		System.out.printf(message, args);
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printError(String error) {

		printfMessage(TextType.ERROR.getText(), error);
	}

	public static void printWinner(String winner) {

		printfMessage(TextType.WINNER.getText(), DelimiterType.COLON.getDelimiter(), winner);
	}

	public static void printCarStatus(String name, StringBuilder position) {
		printfMessage(TextType.CAR_STATUS.getText(), name, DelimiterType.COLON.getDelimiter(), position);
	}

	public static void printRacingResult() {
		printfMessage(TextType.RESULT.getText());
	}
}


