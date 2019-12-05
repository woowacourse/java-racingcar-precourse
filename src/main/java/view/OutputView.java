package view;

import java.util.ArrayList;

import domain.Car;

public class OutputView {
	private static String RESULT_MESSAGE = "실행 결과";

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printCarsPosition(ArrayList<Car> cars) {
		for(Car car : cars) {
			String resultLine = getResultLine(car);
			System.out.println(resultLine);
		}
		System.out.print('\n');
	}

	private static String getResultLine(Car car) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(car.getName());
		stringBuilder.append(" : ");
		for(int i = 0; i < car.getPosition(); i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}
