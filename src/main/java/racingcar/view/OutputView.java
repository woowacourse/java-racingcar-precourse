package racingcar.view;

public class OutputView {

	public static final String INPUT_NAMES_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_COUNT_INSTRUCTION = "시도할 회수는 몇회인가요?";
	public static final String ERROR = "[ERROR] ";
	public static final String FINAL_WINNER_INSTRUCTION = "최종 우승자 : ";
	public static final String RESULT_INSTRUCTION = "실행 결과";

	public static void printInputNamesInstruction() {
		System.out.println(INPUT_NAMES_INSTRUCTION);
	}

	public static void printError(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}

	public static void printInputCountInstruction() {
		System.out.println(INPUT_COUNT_INSTRUCTION);
	}

	public static void printEveryRound(String resultEveryRound) {
		System.out.println(resultEveryRound);
		System.out.println();
	}

	public static void printFinalWinnerInstruction() {
		System.out.print(FINAL_WINNER_INSTRUCTION);
	}

	public static void printNameOfFinalWinners(String nameOfWinners) {
		System.out.println(nameOfWinners);
	}

	public static void printResultInstruction() {
		System.out.println(RESULT_INSTRUCTION);
	}
}
