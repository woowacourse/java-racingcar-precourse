package racingcar.view;

import racingcar.utils.Message;

public class OutputView {

	public static void printInputNamesInstruction() {
		System.out.println(Message.INPUT_NAMES_INSTRUCTION);
	}

	public static void printError(String errorMessage) {
		System.out.println(Message.ERROR + errorMessage);
	}

	public static void printInputCountInstruction() {
		System.out.println(Message.INPUT_COUNT_INSTRUCTION);
	}

	public static void printEveryRound(String resultEveryRound) {
		System.out.println(resultEveryRound);
		System.out.println();
	}

	public static void printFinalWinnerInstruction() {
		System.out.print(Message.FINAL_WINNER_INSTRUCTION);
	}

	public static void printNameOfFinalWinners(String nameOfWinners) {
		System.out.println(nameOfWinners);
	}

	public static void printResultInstruction() {
		System.out.println(Message.RESULT_INSTRUCTION);
	}
}
