package racingcar;

public class MessagePrinter {

	public static final String ASK_FOR_REPETITIONS = "시도할 회수는 몇회인가요?";
	private static final String ASK_FOR_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void printError(IllegalArgumentException exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}

	public static void askCarNameList() {
		System.out.println(ASK_FOR_CAR_NAME_LIST);
	}

	public static void askForRepetitions() {
		System.out.println(ASK_FOR_REPETITIONS);
	}

}
