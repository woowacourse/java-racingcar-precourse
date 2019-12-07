package view;

import java.util.List;

import domain.Car;

public class OutputView {
	private static final String WINNER_DELIMITER = ", ";

	public static void printRacingStart() {
		System.out.println("\n실행 결과");
	}

	private static void printCarState(Car car) {
		System.out.println(car);
	}

	public static void printRaceResult(List<Car> cars) {
		cars.forEach(OutputView::printCarState);
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		String result = String.join(WINNER_DELIMITER, winners);
		System.out.println(result + "가 최종 우승했습니다.");
	}
}
