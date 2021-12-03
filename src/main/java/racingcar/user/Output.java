package racingcar.user;

import racingcar.Car;

public class Output {
	private static final String DISTANCE = "-";
	private static final String COLON = " : ";
	private static final String ROUND_RESULT_MESSAGE = "실행 결과";

	public void printRoundResult(String round, Car[] cars) {
		System.out.println();
		System.out.println(ROUND_RESULT_MESSAGE);
		for (int i = 0; i < Integer.parseInt(round); i++) {
			moveCars(cars);
			System.out.println();
		}
	}

	private void moveCars(Car[] cars) {
		for (Car car : cars) {
			car.move();
			printResult(car);
		}
	}

	private void printResult(Car car) {
		System.out.print(car.getName() + COLON);
		printDistance(car.getPosition());
		System.out.println();
	}

	private void printDistance(int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(DISTANCE);
		}
	}
}
