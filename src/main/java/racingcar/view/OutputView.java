package racingcar.view;

import static racingcar.constant.GameConstants.*;

import java.util.List;

public class OutputView {
	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printAskingCarNames() {
		System.out.println(ASK_CAR_NAMES_MESSAGE);
	}

	public static void printAskingAttemptNumber() {
		System.out.println(ASK_ATTEMPT_NUMBER_MESSAGE);
	}

	public static void printExcutionResultMessage() {
		System.out.println(EXCUTION_RESULT_MESSAGE);
	}

	public static void printExcutionForEachOrderMessage(String excutionForEachOrderMessage) {
		System.out.println(excutionForEachOrderMessage);
	}

	public static void printWinner(List<String> winner) {
		System.out.print(FINAL_WINNER_MESSAGE + COLON);
		System.out.println(String.join(DELIMITER + " ", winner));
	}
}
