package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
	private static final String EXECUTION_RESULT = "실행결과";
	public static final String DELIMITER = " : ";

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
}
