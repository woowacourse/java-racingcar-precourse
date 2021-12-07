package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class OutputView {
	private static final String RESULT_MESSAGE = "\n실행 결과";
	private static String DISPLACEMENT_UNIT = "-";

	private OutputView() {}

	public static void printExecutionResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printProgress(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.print(car.getName() + " : ");
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print(DISPLACEMENT_UNIT);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		String winnerNames = "최종 우승자 : " + String.join(", ", winners);
		System.out.println(winnerNames);
	}
}
