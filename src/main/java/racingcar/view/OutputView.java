package racingcar.view;

import java.util.ArrayList;

import racingcar.model.Car;

public class OutputView {
	private static final String CAR_NAME_INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ROUND_NUMBER_INPUT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String PLAY_RESULT_MESSAGE = "실행 결과";
	private static final String ERROR = "[ERROR]";
	private static final String SPACE = " ";

	public static void printCarNameRequestMessage() {
		System.out.println(CAR_NAME_INPUT_REQUEST_MESSAGE);
	}

	public static void printRoundNumberRequestMessage() {
		System.out.println(ROUND_NUMBER_INPUT_REQUEST_MESSAGE);
	}

	public static void printErrorMessage(String message) {
		System.out.println(ERROR + SPACE + message);
	}

	public static void printPlayResultMessage() {
		printEmptyLine();
		System.out.println(PLAY_RESULT_MESSAGE);
	}

	public static void printCarInfo(Car car) {
		System.out.print(car.getName() + " : ");
		int position = car.getPosition();
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		printEmptyLine();
	}

	public static void printEmptyLine() {
		System.out.println();
	}

	public static void printWinners(ArrayList<String> winners) {
		System.out.print("최종 우승자 : " + String.join(", ", winners));
	}
}