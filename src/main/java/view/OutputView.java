package view;

import java.util.ArrayList;

import domain.Car;

public class OutputView {
	private static String RESULT_MESSAGE = "실행 결과";
	private static String IS_WINNER_MESSAGE = "가 최종 우승했습니다.";

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

	public static void printWinners(ArrayList<String> carNames) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carNames.get(0));
		for(int i = 1; i < carNames.size(); i++) {
			stringBuilder.append(", ");
			stringBuilder.append(carNames.get(i));
		}
		System.out.println(stringBuilder.toString() + IS_WINNER_MESSAGE);
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
