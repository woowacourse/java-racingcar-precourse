package view;

import java.util.List;

import domain.Car;

public class OutputView {
	private static final String WINNER_DELIMITER = ", ";
	private static final String RACING_START_MESSAGE = "\n실행 결과";
	private static final String WINNERS_MESSAGE = "가 최종 우승했습니다.";

	public static void printRacingStart() {
		System.out.println(RACING_START_MESSAGE);
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
		System.out.println(result + WINNERS_MESSAGE);
	}
}
