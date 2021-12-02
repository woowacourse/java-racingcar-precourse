package racingcar.view;

import java.util.ArrayList;

import racingcar.domain.Car;

public class OutputView {
	private static final String EXECUTION_RESULT = "실행결과";
	public static final String DELIMITER = " : ";
	public static final String FINAL_WINNERS = "최종 우승자 : ";
	public static final String COMMA = ", ";

	public void printExecutionResult() {
		System.out.println(EXECUTION_RESULT);
	}

	public void displayPosition(Car car) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(car.getName()).append(DELIMITER);
		for (int i = 0; i < car.getPosition(); i++) {
			stringBuilder.append("-");
		}
		System.out.println(stringBuilder);
	}

	public void printWinners(ArrayList<String> winners) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(FINAL_WINNERS);
		String winnerString = String.join(COMMA, winners);
		stringBuilder.append(winnerString);
		System.out.println(stringBuilder);
	}
}
