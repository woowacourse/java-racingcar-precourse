package racingcar;

import static racingcar.Car.*;

import java.util.List;

import org.assertj.core.util.Lists;

public class Output {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	public static void outputCarPosition(Car[] cars) {
		printCarStatus(cars);
	}

	public static void outputRaceResult(Car[] cars) {

		StringBuilder sb = new StringBuilder();
		System.out.println(RESULT_MESSAGE);

		printWinnerList(cars, sb);
		System.out.println(WINNER_MESSAGE + trimResult(sb));
	}

	private static void printWinnerList(Car[] cars, StringBuilder sb) {
		List<String> ouputList = Judge.judging(cars);
		for(String name : ouputList){
			sb.append(name+", ");
		}
	}

	private static void printCarStatus(Car[] cars) {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.toString()+"\n");
		}
		System.out.println(sb.toString());
	}



	private static String trimResult(StringBuilder sb) {
		String result = sb.toString();
		result = result.substring(0, result.length() - 2);
		return result;
	}

}
