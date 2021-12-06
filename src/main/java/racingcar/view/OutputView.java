package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.utils.Message;

public class OutputView {
	private static String COLON_SIGN = " : ";
	private static String MOVEMENT_SIGN = "-";

	public static void printExecutionResult() {
		System.out.println(Message.EXECUTION_RESULT.getMessage());
	}

	public static void printCarMovementStatus(Car[] carName) {
		for (Car car : carName) {
			System.out.print(car.getName() + COLON_SIGN);
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print(MOVEMENT_SIGN);
			}
			System.out.println();
		}
	}

	public static void printRacingWinner(List<String> winnerList) {
		System.out.print(Message.WINNER_RESULT.getMessage());
		System.out.print(String.join(", ", winnerList));
	}
}
