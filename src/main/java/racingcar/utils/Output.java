package racingcar.utils;

import racingcar.domain.Car;
import racingcar.domain.Judge;

public enum Output {
	OUTPUT_INSTANCE;
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private Judge judge;

	public void initOutputInstance(Judge judge) {
		this.judge = judge;
	}

	public void outputCarPosition(Car[] cars) {
		printCarStatus(cars);
	}

	public void outputRaceResult(Car[] cars) {
		System.out.println(RESULT_MESSAGE);
		printWinnerList(cars);
	}

	private void printWinnerList(Car[] cars) {
		StringBuilder sb = new StringBuilder();

		for (String name : judge.judging(cars)) {
			sb.append(name + ", ");
		}

		System.out.println(WINNER_MESSAGE + trimWinnerResultString(sb));
	}

	private void printCarStatus(Car[] cars) {
		StringBuilder sb = new StringBuilder();

		for (Car car : cars) {
			sb.append(car.toString() + "\n");
		}
		System.out.println(sb.toString());
	}

	private String trimWinnerResultString(StringBuilder sb) {
		String result = sb.toString();
		return result.substring(0, result.length() - 2);
	}

}
