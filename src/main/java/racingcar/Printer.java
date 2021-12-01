package racingcar;

import java.util.Arrays;

public class Printer {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String DASH = "-";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	public static void printProgress(Car[] cars) {
		System.out.println(RESULT_MESSAGE);
		for (Car car : cars) {
			String result = car.getName() + " : ";
			result += buildProgress(car.getPosition());
			System.out.println(result);
		}
		System.out.println();
	}

	private static String buildProgress(int position) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < position; i++) {
			result.append(DASH);
		}
		return result.toString();
	}

	public static void printWinnersAt(Car[] cars, int position) {
		String[] winners = Arrays.stream(cars)
			.filter(c -> c.getPosition() == position)
			.map(Car::getName)
			.toArray(String[]::new);
		System.out.println(WINNER_MESSAGE + String.join(", ", winners));
	}
}
