package racingcar.view;

public class OutputView {

	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_GAME_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

	public static void printInputGameRound() {
		print(INPUT_GAME_ROUND_MESSAGE);
	}

	public static void printInputCarName() {
		print(INPUT_CAR_NAME_MESSAGE);
	}

	public static void printException(Exception exception) {
		print(exception.getMessage());
	}

	private static void print(String message) {
		System.out.println(message);
	}

}
