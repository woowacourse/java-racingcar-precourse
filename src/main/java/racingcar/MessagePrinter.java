package racingcar;

public class MessagePrinter {

	public static final String ASK_FOR_REPETITIONS = "시도할 회수는 몇회인가요?";
	public static final String START_MESSAGE = "실행 결과";
	private static final String ASK_FOR_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String POSITION_INDICATOR = "-";

	public static void printError(IllegalArgumentException exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}

	public static void askCarNameList() {
		System.out.println(ASK_FOR_CAR_NAME_LIST);
	}

	public static void askForRepetitions() {
		System.out.println(ASK_FOR_REPETITIONS);
	}

	public static void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	public static void printExecutionResult(Car[] cars) {
		StringBuilder resultMessage = new StringBuilder();

		for (Car car : cars) {
			resultMessage.append(createPositionMessage(car));
		}

		resultMessage.append("\n");
		System.out.println(resultMessage);
	}

	private static String createPositionMessage(Car car) {
		StringBuilder positionMessage = new StringBuilder();

		positionMessage.append(car.getName());
		positionMessage.append(" : ");
		for (int i = 0; i < car.getPosition(); i++) {
			positionMessage.append(POSITION_INDICATOR);
		}

		return positionMessage.toString();
	}

}
