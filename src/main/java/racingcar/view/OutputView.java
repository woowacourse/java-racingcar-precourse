package racingcar.view;

public class OutputView {
	public static final String ERROR_MESSAGE = "[ERROR] %s";
	public static final String WINNER_MESSAGE = "최종 우승자 : %s";

	public static void printfMessage (String message, Object ...args) {
		System.out.printf(message, args);
		System.out.println();
	}
}

