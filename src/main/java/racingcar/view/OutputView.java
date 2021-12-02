package racingcar.view;

import static constants.RacingCarConstant.*;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	public static void printError(String message) {
		System.out.println(message);
	}

	public static void printExecutionMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}

	public static void printCarPosition(List<Car> racingCars) {
		for (Car car : racingCars) {
			StringBuilder carPosition = new StringBuilder();
			carPosition.append(car.getName()).append(COLON);
			for (int i = 0; i < car.getPosition(); i++) {
				carPosition.append(PROGRESS_BAR);
			}
			System.out.println(carPosition);
		}
		System.out.println();
	}

	public static void printWinner(List<String> winnerNames) {
		StringBuilder resultMessage = new StringBuilder();
		resultMessage.append(FINAL_WINNER_MESSAGE);
		for (int idx = 0; idx < winnerNames.size() - 1; idx++) {
			resultMessage.append(winnerNames.get(idx));
			resultMessage.append(COMMA);
		}
		resultMessage.append(winnerNames.get(winnerNames.size() - 1));
		System.out.println(resultMessage);
	}
}
