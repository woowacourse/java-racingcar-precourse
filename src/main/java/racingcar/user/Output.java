package racingcar.user;

import racingcar.Car;

public class Output {
	private static final String DISTANCE = "-";
	private static final String COLON = " : ";

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
