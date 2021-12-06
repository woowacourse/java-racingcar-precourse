package racingcar;

public class Console {
	private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_INPUT_ERROR_MESSAGE = "[ERROR] 입력한 자동차 이름을 확인하세요";
	private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String TURN_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public static int readTurn() {
		System.out.println(TURN_INPUT_MESSAGE);
		return readTurnLine();
	}

	private static int readTurnLine() {
		String turnInput = camp.nextstep.edu.missionutils.Console.readLine();

		try {
			Validator.validateTurnInput(turnInput);
		} catch (IllegalArgumentException e) {
			System.out.println(TURN_INPUT_ERROR_MESSAGE);
			return readTurnLineAgain();
		}
		return Integer.parseInt(turnInput);
	}

	private static int readTurnLineAgain() {
		return readTurnLine();
	}

	public static String[] readCar() {
		System.out.println(CAR_INPUT_MESSAGE);
		return readCarLine();
	}

	private static String[] readCarLine() {
		String carInput = camp.nextstep.edu.missionutils.Console.readLine();

		try {
			Validator.validateCarInput(carInput);
		} catch (IllegalArgumentException e) {
			System.out.println(CAR_INPUT_ERROR_MESSAGE);
			return readCarLineAgain();
		}
		return carInput.split(",");
	}

	private static String[] readCarLineAgain() {
		return readCarLine();
	}
}
