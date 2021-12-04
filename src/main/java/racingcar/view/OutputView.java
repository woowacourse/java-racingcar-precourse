package racingcar.view;

public class OutputView {

	private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
	private static final String CAR_NAMES_CONDITION = "(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASK_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
	private static final String POSITION_BAR = "-";
	private static final String COLON_WITH_SPACE = " : ";
	private static final String EXECUTION_RESULT = "실행결과";
	private static final String FINAL_WINNER_IS = "최종 우승자";
	private static final int STARTING_POSITION = 0;

	private OutputView() {
	}

	public static void askCarNames() {
		System.out.println(ASK_CAR_NAMES + CAR_NAMES_CONDITION);
	}

	public static void askNumberOfAttempts() {
		System.out.println(ASK_NUMBER_OF_ATTEMPTS);
	}

	public static void printError(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printPosition(int position) {
		for (int i = STARTING_POSITION; i < position; i++) {
			System.out.print(POSITION_BAR);
		}
		printNewLine();
	}

	public static void printCarNameAndColon(String car) {
		System.out.print(car + COLON_WITH_SPACE);
	}

	public static void printExecutionResult() {
		OutputView.printNewLine();
		System.out.println(EXECUTION_RESULT);
	}

	public static void printWinner(String winner) {
		OutputView.printNewLine();
		System.out.print(FINAL_WINNER_IS + COLON_WITH_SPACE + winner);
	}
}
