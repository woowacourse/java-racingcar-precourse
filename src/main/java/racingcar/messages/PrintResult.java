package racingcar.messages;

import racingcar.Car;

public class PrintResult {
	private static final String resultDelimiter = "-";

	public void printGameResult(Car car) {
		int moveCount = car.getPosition();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < moveCount; i++) {
			stringBuilder.append(resultDelimiter);
		}
		System.out.println(car.getName() + " : " + stringBuilder);
	}
}
