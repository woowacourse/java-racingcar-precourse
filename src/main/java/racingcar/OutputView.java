package racingcar;

import java.util.List;

public class OutputView {
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String CAR_STATUS_MESSAGE = "%s : %s\n";

	private OutputView() {
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	private static void printEmptyLine() {
		System.out.println();
	}

	public static void printCars(List<Car> cars) {
		System.out.println(GAME_RESULT_MESSAGE);
		for (Car car : cars) {
			printCar(car);
		}
		printEmptyLine();
	}

	private static void printCar(Car car) {
		System.out.printf(CAR_STATUS_MESSAGE, car.getName(), formatPosition(car.getPosition()));
	}

	private static String formatPosition(int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = position; i > 0; --i) {
			sb.append('-');
		}
		return sb.toString();
	}
}
