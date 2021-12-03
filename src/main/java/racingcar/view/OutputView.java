package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
	private static String COLON_SIGN = " : ";
	private static String MOVEMENT_SIGN = "-";

	public static void printInvalidCarName() {
		System.out.println(Message.ERROR_INVALID_CAR_NAME.getMessage());

	}
	public static void printInvalidAttemptNumber() {
		System.out.println(Message.ERROR_INVALID_ATTEMPT_NUMBER.getMessage());
	}

	public static void printExecutionResult() {
		System.out.println(Message.EXECUTION_RESULT.getMessage());
	}

	public static void printCarMovementStatus(Car[] carName) {
		for (Car car : carName) {
			System.out.print(car.getName() + COLON_SIGN);
			for (int i = 0; i<car.getPosition(); i++) {
				System.out.print(MOVEMENT_SIGN);
			}
			System.out.println();
		}
	}
}
