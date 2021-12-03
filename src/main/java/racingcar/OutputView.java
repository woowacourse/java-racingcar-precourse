package racingcar;

import java.util.List;

public class OutputView {
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String CAR_STATUS_MESSAGE = "%s : %s\n";
	private static final String WINNER_MESSAGE = "최종 우승자 : %s\n";
	private static final String WINNER_SEPARATE_SIGN = ", ";
	private static final int WINNER_TRIM_COUNT = 2;

	private OutputView() {
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printCars(List<Car> cars) {
		System.out.println(GAME_RESULT_MESSAGE);
		for (Car car : cars) {
			printCar(car);
		}
		printEmptyLine();
	}

	private static void printCar(Car car) {
		System.out.printf(CAR_STATUS_MESSAGE, car.getName(), formatCarPosition(car.getPosition()));
	}

	private static String formatCarPosition(int position) {
		initStringBuilder();
		formatPosition(position);
		return STRING_BUILDER.toString();
	}

	private static void initStringBuilder() {
		STRING_BUILDER.setLength(0);
	}

	private static void formatPosition(int position) {
		for (int i = position; i > 0; --i) {
			STRING_BUILDER.append('-');
		}
	}

	private static void printEmptyLine() {
		System.out.println();
	}

	public static void printRacingWinners(List<Car> cars) {
		System.out.printf(WINNER_MESSAGE, formatWinners(cars));
	}

	private static String formatWinners(List<Car> cars) {
		initStringBuilder();
		formatWinnerNames(cars);
		cutLastSeparateSign();
		return STRING_BUILDER.toString();
	}

	private static void formatWinnerNames(List<Car> cars) {
		for (Car car : cars) {
			STRING_BUILDER
				.append(car.getName())
				.append(WINNER_SEPARATE_SIGN);
		}
	}

	private static void cutLastSeparateSign() {
		STRING_BUILDER.setLength(STRING_BUILDER.length() - WINNER_TRIM_COUNT);
	}
}
