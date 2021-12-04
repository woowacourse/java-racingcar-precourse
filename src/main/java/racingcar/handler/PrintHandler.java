package racingcar.handler;

import java.util.List;

import racingcar.domain.Car;

public class PrintHandler {
	public static final String INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_NUMBER_MSG = "시도할 횟수는 몇회인가요?";
	public static final String RESULT_MSG = "실행 결과";
	public static final String WINNER_MSG = "최종 우승자 : ";

	public static void printInputNameMsg() {
		System.out.println(INPUT_NAME_MSG);
	}

	public static void printErrorMsg(Exception exception) {
		System.out.println(exception.getMessage());
	}

	public static void printInputNumberMsg() {
		System.out.println(INPUT_NUMBER_MSG);
	}

	public static void printResultMsg() {
		System.out.println(RESULT_MSG);
	}

	public static void printBlank() {
		System.out.println();
	}

	public static void printCar(Car car) {
		StringBuilder sb = new StringBuilder(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			sb.append("-");
		}
		System.out.println(sb);
	}

	public static void printWinners(String winnerNames) {
		System.out.println(WINNER_MSG + winnerNames);
	}
}
