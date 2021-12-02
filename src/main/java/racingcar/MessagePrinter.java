package racingcar;

public class MessagePrinter {

	private static final String ASK_FOR_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void printError(IllegalArgumentException exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}

	public static void askCarNameList() {
		System.out.println(ASK_FOR_CAR_NAME_LIST);
	}

}
