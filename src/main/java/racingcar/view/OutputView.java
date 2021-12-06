package racingcar.view;

import java.util.ArrayList;

import racingcar.domain.Car;
import racingcar.utils.Message;

public class OutputView {
	private static String COLON_SIGN = " : ";
	private static String MOVEMENT_SIGN = "-";

	public static void printInvalidCarNameListSize() {
		System.out.println(Message.ERROR_CAR_NAME_LIST_SIZE.getMessage());
	}

	public static void printInvalidBlankInput() {
		System.out.println(Message.ERROR_INPUT_IS_BLANK.getMessage());
	}
	public static void printInvalidCarNameLength() {
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

	public static void printRacingWinner(ArrayList<Car> winnerList) {
		System.out.print(Message.WINNER_RESULT.getMessage());
		ArrayList<String> resultWinnerNames = new ArrayList<>();
		for (Car car: winnerList) {
			resultWinnerNames.add(car.getName());
		}
		System.out.print(String.join(", ", resultWinnerNames));
	}
}
