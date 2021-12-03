package racingcar.utils;


import static racingcar.domain.Judge.*;

import racingcar.domain.Car;
import racingcar.domain.Judge;

public class Output {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static Judge judge;

	static {
		judge = JUDGE_INSTANCE;
	}

	public static void outputCarPosition(Car[] cars) {
		printCarStatus(cars);
	}

	public static void outputRaceResult(Car[] cars) {
		System.out.println(RESULT_MESSAGE);
		printWinnerList(cars);
	}

	private static void printWinnerList(Car[] cars) {
		StringBuilder sb = new StringBuilder();

		for (String name : judge.judging(cars)) {
			sb.append(name + ", ");
		}

		System.out.println(WINNER_MESSAGE + trimWinnerResultString(sb));
	}

	private static void printCarStatus(Car[] cars) {
		StringBuilder sb = new StringBuilder();

		for (Car car : cars) {
			sb.append(car.toString() + "\n");
		}
		System.out.println(sb.toString());
	}

	private static String trimWinnerResultString(StringBuilder sb) {
		String result = sb.toString();
		return result.substring(0, result.length() - 2);
	}

}
