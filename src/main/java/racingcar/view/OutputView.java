package racingcar.view;

public class OutputView {
	public static final String ERROR_MESSAGE = "[ERROR] %s";
	public static final String WINNER_MESSAGE = "최종 우승자 : %s";
	public static final String CAR_DISTANCE_MESSAGE =  "%s : %s";

	public static void printfMessage(String message, Object... args) {
		System.out.printf(message, args);
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printError(String error) {
		printfMessage(ERROR_MESSAGE, error);
	}

	public static void printWinner(StringBuffer winner) {
		printfMessage(WINNER_MESSAGE, winner);
	}

	public static void printCarNameAndPosition(String name, StringBuilder position){
		printfMessage(CAR_DISTANCE_MESSAGE, name, position);
	}

}


