package view;

import java.util.List;

import domain.Car;

public class OutputView {
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
}
