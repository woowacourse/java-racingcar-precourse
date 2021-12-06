package racingcar.view;

import static racingcar.utils.Message.*;


import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	public static void printExecutionResult() {
		System.out.println(EXECUTION_RESULT.getMessage());
	}

	public static void printCarMovementStatus(Car[] carName) {
		for (Car car : carName) {
			System.out.print(car.getName() + COLON_SIGN.getMessage());
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print(MOVEMENT_SIGN.getMessage());
			}
			System.out.println();
		}
	}

	public static void printRacingWinner(List<String> winnerList) {
		System.out.print(WINNER_RESULT.getMessage());
		System.out.print(String.join(", ", winnerList));
	}
}
